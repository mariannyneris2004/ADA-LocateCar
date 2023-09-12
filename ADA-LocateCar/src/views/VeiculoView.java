package views;

import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoNaoEncontradoException;
import exceptions.VeiculoNaoEncontradoException;
import model.Aluguel;
import model.Cliente;
import model.TipoCarro;
import model.Veiculo;
import service.*;
import utils.EntradaDeDados;

import java.util.Map;

public class VeiculoView {
    public static void cadastrarVeiculo(CadastrarVeiculo cadastrarVeiculo) {
        System.out.print("Digite a placa do veículo: ");
        String placa = EntradaDeDados.getString();
        System.out.print("Digite a marca do veículo: ");
        String marca = EntradaDeDados.getString();
        System.out.print("Digite o modelo do veículo: ");
        String modelo = EntradaDeDados.getString();
        System.out.print("Digite o tipo do veículo (PEQUENO, MEDIO ou SUV): ");
        String tipo = EntradaDeDados.getString();

        try {
            Veiculo veiculo = new Veiculo(placa, marca, modelo, TipoCarro.valueOf(tipo.toUpperCase()));
            cadastrarVeiculo.cadastrar(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (IllegalArgumentException e){
            throw new ArgumentoInvalidoException("Tipo inválido!");
        }

    }

    public static void alterarVeiculo(AlterarVeiculo alterarVeiculo, BuscarVeiculo buscarVeiculo) {
        System.out.print("Digite a placa do veículo que deseja alterar: ");
        String placa = EntradaDeDados.getString();
        Veiculo veiculo = buscarVeiculo.buscarPorPlaca(placa);

        System.out.print("Digite a marca do veículo: ");
        String marca = EntradaDeDados.getString();
        System.out.print("Digite o modelo do veículo: ");
        String modelo = EntradaDeDados.getString();
        System.out.print("Digite o tipo do veículo (PEQUENO, MEDIO ou SUV): ");
        String tipo = EntradaDeDados.getString();

        if ("pequeno".equalsIgnoreCase(tipo) || "medio".equalsIgnoreCase(tipo) || "suv".equalsIgnoreCase(tipo.toUpperCase())){
            throw new ArgumentoInvalidoException("Tipo Inválido!");
        } else {
            Veiculo veiculoAlterado = new Veiculo(veiculo.getPlaca(), marca, modelo, TipoCarro.valueOf(tipo));

            alterarVeiculo.alterar(veiculoAlterado);
            System.out.println("Veículo alterado com sucesso!");
        }
    }

    public static void buscarVeiculo(BuscarVeiculo buscarVeiculo) {
        System.out.print("Digite parte do modelo do veículo: ");
        String parteModelo = EntradaDeDados.getString();

        Map<String, Veiculo> veiculosEncontrados = buscarVeiculo.buscarPorModelo(parteModelo);

        if (!veiculosEncontrados.isEmpty()){
            System.out.println("Veículos encontrados:");
            System.out.println("======================");
            for (Veiculo veiculo : veiculosEncontrados.values()) {
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Marca: " + veiculo.getMarca());
                System.out.println("Tipo: " + veiculo.getTipo());
                System.out.println("Disponível: " + (veiculo.isDisponivel() ? "Sim" : "Não"));
                System.out.println();
                System.out.println("======================");
            }
        } else {
            throw new ObjetoNaoEncontradoException("Nenhum veículo encontrado!");
        }
    }

    public static void alugarVeiculo(BuscarVeiculo buscarVeiculo, BuscarCliente buscarCliente,
                                      AlugarVeiculo alugarVeiculo) throws ObjetoNaoEncontradoException {
        for (Veiculo veiculoCadastrado:buscarVeiculo.veiculos().values()) {
            System.out.println(veiculoCadastrado.getPlaca() + " - " + veiculoCadastrado.getModelo() + " / " +
                    veiculoCadastrado.getMarca());
        }
        System.out.print("Digite a placa do veículo que deseja alugar: ");
        String placa = EntradaDeDados.getString();
        Veiculo veiculo = buscarVeiculo.buscarPorPlaca(placa);

        if (veiculo != null) {
            if (veiculo.isDisponivel()) {
                System.out.print("Digite o documento do cliente (CPF ou CNPJ): ");
                String idCliente = EntradaDeDados.getString();
                Cliente cliente = buscarCliente.buscarClientePorDocumento(idCliente);

                if (cliente != null) {
                    System.out.print("Digite a data do aluguel (dd/mm/aaaa): ");
                    String dataAluguel = EntradaDeDados.getString();

                    System.out.print("Digite o horário do aluguel (hh:mm): ");
                    String horaAluguel = EntradaDeDados.getString();

                    Aluguel aluguel = new Aluguel(veiculo, cliente, dataAluguel, horaAluguel);
                    alugarVeiculo.alugarVeiculo(aluguel);
                    System.out.println(cliente.getNome() + " alugou o veículo " + veiculo.getModelo() +
                            ", com a placa: " + veiculo.getPlaca());
                } else {
                    throw new ObjetoNaoEncontradoException("Cliente não encontrado!");
                }
            } else {
                throw new ObjetoNaoEncontradoException("Veículo já alugado!");
            }
        } else {
            throw new ObjetoNaoEncontradoException("Veículo não encontrado!");
        }
    }

    public static void devolverVeiculo(BuscarVeiculo buscarVeiculo, BuscarCliente buscarCliente,
                                        BuscarAluguel buscarAluguel, DevolverVeiculo devolverVeiculo) {
        System.out.print("Digite a placa do veículo que deseja devolver: ");
        String placa = EntradaDeDados.getString();
        Veiculo veiculo = buscarVeiculo.buscarPorPlaca(placa);

        if (veiculo != null) {
            System.out.print("Digite o documento do cliente (CPF ou CNPJ): ");
            String idCliente = EntradaDeDados.getString();
            Cliente cliente = buscarCliente.buscarClientePorDocumento(idCliente);

            if (cliente != null) {
                System.out.print("Digite a data de aluguel (dd/mm/aaaa): ");
                String dataAluguel = EntradaDeDados.getString();

                Aluguel aluguel = buscarAluguel.buscarPorClienteEVeiculo(cliente, veiculo, dataAluguel);

                if (aluguel != null){
                    System.out.print("Digite a data da devolução (dd/mm/aaaa): ");
                    String dataDevolucao = EntradaDeDados.getString();

                    System.out.print("Digite o horário da devolução (hh:mm): ");
                    String horaDevolucao = EntradaDeDados.getString();

                    System.out.print("Digite o local para a devolução: ");
                    String local = EntradaDeDados.getString();

                    double valorTotal = devolverVeiculo.devolverVeiculo(buscarAluguel, cliente, veiculo, aluguel.getData(),
                            aluguel.getHoraAluguel(), dataDevolucao, horaDevolucao, local);

                    System.out.println("Veículo devolvido com sucesso.");
                    System.out.println(cliente.getNome() + " alugou o veículo " + veiculo.getModelo() + " / " +
                            veiculo.getMarca() + " e o devolveu em " + local);
                    System.out.println("Valor do aluguel: R$ " + valorTotal);
                } else {
                    throw new ObjetoNaoEncontradoException("Aluguel não encontrado para esse cliente e veículo");
                }
            } else {
                throw new ObjetoNaoEncontradoException("Cliente não encontrado.");
            }
        } else {
            throw new ObjetoNaoEncontradoException("Veículo não encontrado.");
        }
    }

}
