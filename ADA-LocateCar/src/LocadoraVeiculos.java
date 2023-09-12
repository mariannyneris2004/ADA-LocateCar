import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoCadastradoException;
import exceptions.ObjetoNaoEncontradoException;
import exceptions.VeiculoNaoEncontradoException;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import repository.AluguelRepository;
import repository.ClienteRepository;
import repository.VeiculoRepository;
import service.*;
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
        AluguelRepository aluguelRepository = new AluguelRepository();

        CadastrarVeiculo cadastrarVeiculo = new CadastrarVeiculo(veiculoRepository);
        CadastrarCliente cadastrarCliente = new CadastrarCliente(clienteRepository);
        BuscarVeiculo buscarVeiculo = new BuscarVeiculo(veiculoRepository);
        BuscarCliente buscarCliente = new BuscarCliente(clienteRepository);
        BuscarAluguel buscarAluguel = new BuscarAluguel(aluguelRepository);
        DevolverVeiculo devolverVeiculo = new DevolverVeiculo(aluguelRepository);
        AlterarVeiculo alterarVeiculo = new AlterarVeiculo(veiculoRepository);
        AlterarCliente alterarCliente = new AlterarCliente(clienteRepository);
        AlugarVeiculo alugarVeiculo = new AlugarVeiculo(aluguelRepository);

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
                        try {
                            ClienteView.alterarCliente(alterarCliente, buscarCliente);
                        } catch (ObjetoNaoEncontradoException e){
                            System.out.println(e.getMessage());
                        } catch (ArgumentoInvalidoException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "6":
                        try {
                            VeiculoView.alugarVeiculo(buscarVeiculo, buscarCliente, alugarVeiculo);
                        } catch (ObjetoCadastradoException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "7":
                        try {
                            VeiculoView.devolverVeiculo(buscarVeiculo, buscarCliente, buscarAluguel, devolverVeiculo);
                        } catch (ObjetoNaoEncontradoException e){
                            System.out.println(e.getMessage());
                        }
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
            System.out.println(e.getMessage());
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
