import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Veiculo {
    private String placa;
    private String nome;
    private String tipo;
    private boolean disponivel = true;

    public Veiculo(String placa, String nome, String tipo) {
        this.placa = placa;
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

class Cliente {
    private String id;
    private String nome;

    public Cliente(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

class Aluguel {
    private Veiculo veiculo;
    private Cliente cliente;
    private String data;
    private int horasAlugadas;

    public Aluguel(Veiculo veiculo, Cliente cliente, String data, int horasAlugadas) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.data = data;
        this.horasAlugadas = horasAlugadas;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getData() {
        return data;
    }

    public int getHorasAlugadas() {
        return horasAlugadas;
    }
}

public class LocadoraVeiculos {
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Aluguel> alugueis = new ArrayList<>();

    public static void main(String[] args) {
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
                    cadastrarVeiculo();
                    break;
                case 2:
                    alterarVeiculo();
                    break;
                case 3:
                    buscarVeiculo();
                    break;
                case 4:
                    cadastrarCliente();
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

    private static void cadastrarVeiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        System.out.print("Digite o nome do veículo: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tipo do veículo (PEQUENO, MEDIO ou SUV): ");
        String tipo = scanner.nextLine();

        Veiculo veiculo = new Veiculo(placa, nome, tipo);
        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    private static void alterarVeiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo que deseja alterar: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if (veiculo != null) {
            System.out.print("Digite o novo nome do veículo: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo tipo do veículo (PEQUENO, MEDIO ou SUV): ");
            String novoTipo = scanner.nextLine();

            veiculo.setNome(novoNome);
            veiculo.setTipo(novoTipo);
            System.out.println("Veículo alterado com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static void buscarVeiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite parte do nome do veículo: ");
        String parteNome = scanner.nextLine();

        List<Veiculo> veiculosEncontrados = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getNome().contains(parteNome)) {
                veiculosEncontrados.add(veiculo);
            }
        }

        if (veiculosEncontrados.isEmpty()) {
            System.out.println("Nenhum veículo encontrado com o nome informado.");
        } else {
            System.out.println("Veículos encontrados:");
            for (Veiculo veiculo : veiculosEncontrados) {
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Nome: " + veiculo.getNome());
                System.out.println("Tipo: " + veiculo.getTipo());
                System.out.println("Disponível: " + (veiculo.isDisponivel() ? "Sim" : "Não"));
                System.out.println();
            }
        }
    }

    private static void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tipo de cliente (PF para Pessoa Física, PJ para Pessoa Jurídica): ");
        String tipoCliente = scanner.nextLine();

        if (tipoCliente.equalsIgnoreCase("PF")) {
            System.out.print("Digite o CPF do cliente: ");
            String cpf = scanner.nextLine();
            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.nextLine();
            Cliente cliente = new Cliente(cpf, nome);
            clientes.add(cliente);
            System.out.println("Cliente Pessoa Física cadastrado com sucesso!");
        } else if (tipoCliente.equalsIgnoreCase("PJ")) {
            System.out.print("Digite o CNPJ do cliente: ");
            String cnpj = scanner.nextLine();
            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.nextLine();
            Cliente cliente = new Cliente(cnpj, nome);
            clientes.add(cliente);
            System.out.println("Cliente Pessoa Jurídica cadastrado com sucesso!");
        } else {
            System.out.println("Tipo de cliente inválido.");
        }
    }

    private static void alterarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do cliente (CPF ou CNPJ): ");
        String id = scanner.nextLine();
        Cliente cliente = buscarClientePorId(id);

        if (cliente != null) {
            System.out.print("Digite o novo nome do cliente: ");
            String novoNome = scanner.nextLine();
            cliente.setNome(novoNome);
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

    private static Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null;
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
