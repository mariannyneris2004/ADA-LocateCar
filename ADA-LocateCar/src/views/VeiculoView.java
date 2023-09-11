package views;

import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoNaoEncontradoException;
import model.TipoCarro;
import model.Veiculo;
import service.AlterarVeiculo;
import service.CadastrarVeiculo;
import service.BuscarVeiculo;
import utils.EntradaDeDados;

import java.util.Map;
import java.util.Scanner;

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

        if ("pequeno".equalsIgnoreCase(tipo) || "medio".equalsIgnoreCase(tipo) || "suv".equalsIgnoreCase(tipo)){
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
}
