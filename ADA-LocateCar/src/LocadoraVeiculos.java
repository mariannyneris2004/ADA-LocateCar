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
            int opcao = 0;

            do {
                opcao = MenuView.menu();

                switch (opcao) {
                    case 1:
                        VeiculoView.cadastrarVeiculo(cadastrarVeiculo);
                        break;
                    case 2:
                        VeiculoView.alterarVeiculo(alterarVeiculo, buscarVeiculo);
                        break;
                    case 3:
                        VeiculoView.buscarVeiculo(buscarVeiculo);
                        break;
                    case 4:
                        ClienteView.cadastrarCliente(cadastrarCliente);
                        break;
                    case 5:
                        //alterarCliente();
                        break;
                    case 6:
                        //alugarVeiculo();
                        break;
                    case 7:
                        //devolverVeiculo();
                        break;
                    case 8:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;

                }
            } while (opcao != 8);
        } catch (ArgumentoInvalidoException e){
            System.out.println(e.getMessage());
        } catch (ObjetoCadastradoException e){
            System.out.println(e.getMessage());
        } catch (ObjetoNaoEncontradoException e){
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Ocorreu um erro...");
        }
    }
}
