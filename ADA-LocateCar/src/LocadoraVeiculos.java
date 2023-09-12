import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoCadastradoException;
import exceptions.ObjetoNaoEncontradoException;
import repository.AluguelRepository;
import repository.ClienteRepository;
import repository.VeiculoRepository;
import service.api.*;
import service.impl.*;
import service.impl.AlterarCliente;
import service.impl.AlterarVeiculo;
import service.impl.BuscarAluguel;
import service.impl.BuscarCliente;
import service.impl.BuscarVeiculo;
import service.impl.CadastrarCliente;
import service.impl.CadastrarVeiculo;
import views.ClienteView;
import views.MenuView;
import views.VeiculoView;

public class LocadoraVeiculos {
    public static void main(String[] args) {
        ClienteRepository clienteRepository = new ClienteRepository();
        VeiculoRepository veiculoRepository = new VeiculoRepository();
        AluguelRepository aluguelRepository = new AluguelRepository();

        service.api.CadastrarVeiculo cadastrarVeiculo = new CadastrarVeiculo(veiculoRepository);
        service.api.CadastrarCliente cadastrarCliente = new CadastrarCliente(clienteRepository);
        service.api.BuscarVeiculo buscarVeiculo = new BuscarVeiculo(veiculoRepository);
        service.api.BuscarCliente buscarCliente = new BuscarCliente(clienteRepository);
        service.api.BuscarAluguel buscarAluguel = new BuscarAluguel(aluguelRepository);
        Devolver devolverVeiculo = new DevolverVeiculo(aluguelRepository);
        service.api.AlterarVeiculo alterarVeiculo = new AlterarVeiculo(veiculoRepository);
        service.api.AlterarCliente alterarCliente = new AlterarCliente(clienteRepository);
        Alugar alugarVeiculo = new AlugarVeiculo(aluguelRepository);

        try {
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
}
