import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import repository.ClienteRepository;
import repository.VeiculoRepository;
import service.AlterarVeiculo;
import service.BuscarVeiculo;
import service.CadastrarCliente;
import service.CadastrarVeiculo;
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
                    //alterarVeiculo();
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
    }





}
