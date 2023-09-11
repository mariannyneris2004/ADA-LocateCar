import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoCadastradoException;
import exceptions.ObjetoNaoEncontradoException;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import repository.ClienteRepository;
import repository.VeiculoRepository;
import service.AlterarVeiculo;
import service.BuscarVeiculo;
import service.CadastrarCliente;
import service.CadastrarVeiculo;
import utils.EntradaDeDados;
import views.ClienteView;
import views.MenuView;
import views.VeiculoView;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

        try {
            Scanner scanner = new Scanner(System.in);
            String opcao = "";

            do {
                opcao = MenuView.menu();

                switch (opcao) {
                    case "1":
                        try {
                            VeiculoView.cadastrarVeiculo(cadastrarVeiculo);
                        } catch (ArgumentoInvalidoException e){
                            System.out.println(e.getMessage());
                        } catch (ObjetoCadastradoException e){
                            System.out.println(e.getMessage());
                        } catch (ObjetoNaoEncontradoException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "2":
                        try {
                            VeiculoView.alterarVeiculo(alterarVeiculo, buscarVeiculo);
                        } catch (ArgumentoInvalidoException e){
                            System.out.println(e.getMessage());
                        } catch (ObjetoCadastradoException e){
                            System.out.println(e.getMessage());
                        } catch (ObjetoNaoEncontradoException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "3":
                        try {
                            VeiculoView.buscarVeiculo(buscarVeiculo);
                        } catch (ArgumentoInvalidoException e){
                            System.out.println(e.getMessage());
                        } catch (ObjetoCadastradoException e){
                            System.out.println(e.getMessage());
                        } catch (ObjetoNaoEncontradoException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "4":
                        try {
                            ClienteView.cadastrarCliente(cadastrarCliente);
                        } catch (ArgumentoInvalidoException e){
                            System.out.println(e.getMessage());
                        } catch (ObjetoCadastradoException e){
                            System.out.println(e.getMessage());
                        } catch (ObjetoNaoEncontradoException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "5":
                        //alterarCliente();
                        break;
                    case "6":
                        //alugarVeiculo();
                        break;
                    case "7":
                        //devolverVeiculo();
                        break;
                    case "8":
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;

                }
            } while (!opcao.equals("8"));
        } catch (RuntimeException e){
            System.out.println("Ocorreu um erro...");
        }
    }

    private static double calcularValorAluguel(int horasAlugadas, String tipoVeiculo, Cliente cliente) {
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
    
        double valorTotal = dias * valorDiaria;
    
        if (cliente.getDocumento().length() == 11 && dias > 5) {
            valorTotal *= 0.95; // Desconto de 5% para cliente Pessoa Física com mais de 5 diárias
        } else if (cliente.getDocumento().length() == 14 && dias > 3) {
            valorTotal *= 0.90; // Desconto de 10% para cliente Pessoa Jurídica com mais de 3 diárias
        }
    
        return valorTotal;
    }
}
