package service;

import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import repository.ClienteRepository;
import repository.VeiculoRepository;
import views.ClienteView;
import views.VeiculoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocadoraVeiculos {
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Aluguel> alugueis = new ArrayList<>();

    public static void main(String[] args) {
        ClienteRepository clienteRepository = new ClienteRepository();
        VeiculoRepository veiculoRepository = new VeiculoRepository();

        CadastrarVeiculo cadastrarVeiculo = new CadastrarVeiculo(veiculoRepository);
        CadastrarCliente cadastrarCliente = new CadastrarCliente(clienteRepository);
        BuscarVeiculo buscarVeiculo = new BuscarVeiculo(veiculoRepository);
        AlterarVeiculo alterarVeiculo = new AlterarVeiculo(veiculoRepository);

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Locadora de Veículos ===");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Alterar Veículo");
            System.out.println("3. Buscar Veículo");
            System.out.println("4. Cadastrar Cliente");
            System.out.println("5. Alterar Cliente");
            System.out.println("6. Alugar Veículo");
            System.out.println("7. Devolver Veículo");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    VeiculoView.cadastrarVeiculo(cadastrarVeiculo);
                    break;
                case 2:
                    alterarVeiculo();
                    break;
                case 3:
                    VeiculoView.buscarVeiculo(buscarVeiculo);
                    break;
                case 4:
                    ClienteView.cadastrarCliente(cadastrarCliente);
                    break;
                case 5:
                    alterarCliente();
                    break;
                case 6:
                    alugarVeiculo();
                    break;
                case 7:
                    devolverVeiculo();
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 8);
    }


    private static void alterarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do cliente (CPF ou CNPJ): ");
        String id = scanner.nextLine();
        Cliente cliente = buscarClientePorId(id);

        if (cliente != null) {
            System.out.print("Digite o novo nome do cliente: ");
            String novoNome = scanner.nextLine();
            //cliente.setNome(novoNome);
            System.out.println("Cliente alterado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void alugarVeiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo que deseja alugar: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if (veiculo != null) {
            if (veiculo.isDisponivel()) {
                System.out.print("Digite o ID do cliente (CPF ou CNPJ): ");
                String idCliente = scanner.nextLine();
                Cliente cliente = buscarClientePorId(idCliente);

                if (cliente != null) {
                    System.out.print("Digite a data do aluguel (dd/mm/aaaa): ");
                    String dataAluguel = scanner.nextLine();
                    System.out.print("Digite o número de horas do aluguel: ");
                    int horasAlugadas = scanner.nextInt();

                    veiculo.setDisponivel(false);
                    Aluguel aluguel = new Aluguel(veiculo, cliente, dataAluguel, horasAlugadas);
                    alugueis.add(aluguel);
                    System.out.println("Veículo alugado com sucesso!");
                } else {
                    System.out.println("Cliente não encontrado.");
                }
            } else {
                System.out.println("O veículo não está disponível para aluguel.");
            }
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static void devolverVeiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo que deseja devolver: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if (veiculo != null) {
            System.out.print("Digite o ID do cliente (CPF ou CNPJ): ");
            String idCliente = scanner.nextLine();
            Cliente cliente = buscarClientePorId(idCliente);

            if (cliente != null) {
                System.out.print("Digite a data da devolução (dd/mm/aaaa): ");
                String dataDevolucao = scanner.nextLine();

                for (Aluguel aluguel : alugueis) {
                    if (aluguel.getVeiculo().getPlaca().equals(placa) &&
                            aluguel.getCliente().getId().equals(idCliente) &&
                            aluguel.getData().equals(dataDevolucao)) {
                        int horasAlugadas = aluguel.getHorasAlugadas();
                        double valorTotal = calcularValorAluguel(horasAlugadas, veiculo.getTipo());
                        if (cliente.getId().length() == 11 && horasAlugadas > 5) {
                            valorTotal *= 0.95; // Desconto de 5% para cliente Pessoa Física com mais de 5 diárias
                        } else if (cliente.getId().length() == 14 && horasAlugadas > 3) {
                            valorTotal *= 0.90; // Desconto de 10% para cliente Pessoa Jurídica com mais de 3 diárias
                        }
                        veiculo.setDisponivel(true);
                        alugueis.remove(aluguel);
                        System.out.println("Veículo devolvido com sucesso.");
                        System.out.println("Valor do aluguel: R$ " + valorTotal);
                        return;
                    }
                }
                System.out.println("Aluguel não encontrado para o veículo e cliente informados.");
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static Cliente buscarClientePorId(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equalsIgnoreCase(id)) {
                return cliente;
            }
        }
        return null;
    }

    private static double calcularValorAluguel(int horasAlugadas, String tipoVeiculo) {
        double valorDiaria;
        switch (tipoVeiculo.toUpperCase()) {
            case "PEQUENO":
                valorDiaria = 100.00;
                break;
            case "MEDIO":
                valorDiaria = 150.00;
                break;
            case "SUV":
                valorDiaria = 200.00;
                break;
            default:
                valorDiaria = 0.00;
        }
        int dias = horasAlugadas / 24;
        int horasRestantes = horasAlugadas % 24;
        if (horasRestantes > 0) {
            dias++;
        }
        return dias * valorDiaria;
    }
}
