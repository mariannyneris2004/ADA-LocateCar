package views;

import model.Veiculo;
import service.AlterarVeiculo;
import service.CadastrarVeiculo;
import service.BuscarVeiculo;

import java.util.Map;
import java.util.Scanner;

public class VeiculoView {
    public static void cadastrarVeiculo(CadastrarVeiculo cadastrarVeiculo) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        System.out.print("Digite a marca do veículo: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite o tipo do veículo (PEQUENO, MEDIO ou SUV): ");
        String tipo = scanner.nextLine();

        Veiculo veiculo = new Veiculo(placa, marca, modelo, tipo);
        cadastrarVeiculo.cadastrar(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public static void alterarVeiculo(AlterarVeiculo alterarVeiculo, BuscarVeiculo buscarVeiculo) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo que deseja alterar: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = buscarVeiculo.buscarPorPlaca(placa);

        if (veiculo != null) {
            System.out.print("Digite o novo nome do veículo: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo tipo do veículo (PEQUENO, MEDIO ou SUV): ");
            String novoTipo = scanner.nextLine();

            //veiculo.setNome(novoNome);
            //veiculo.setTipo(novoTipo);
            System.out.println("Veículo alterado com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    public static void buscarVeiculo(BuscarVeiculo buscarVeiculo) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite parte do modelo do veículo: ");
        String parteModelo = scanner.nextLine();

        Map<String, Veiculo> veiculosEncontrados = buscarVeiculo.buscarPorModelo(parteModelo);

        if (veiculosEncontrados.isEmpty()) {
            System.out.println("Nenhum veículo encontrado com o nome informado.");
        } else {
            System.out.println("Veículos encontrados:");
            for (Veiculo veiculo : veiculosEncontrados.values()) {
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Marca: " + veiculo.getMarca());
                System.out.println("Tipo: " + veiculo.getTipo());
                System.out.println("Disponível: " + (veiculo.isDisponivel() ? "Sim" : "Não"));
                System.out.println();
            }
        }
    }
}
