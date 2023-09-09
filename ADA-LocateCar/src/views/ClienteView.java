package views;

import model.Cliente;
import service.CadastrarCliente;

import java.util.Scanner;

public class ClienteView {
    public static void cadastrarCliente(CadastrarCliente cadastrarCliente) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o tipo de cliente (PF para Pessoa Física, PJ para Pessoa Jurídica): ");
            String tipoCliente = scanner.nextLine();

            if (tipoCliente.equalsIgnoreCase("PF")) {
                System.out.print("Digite o CPF do cliente: ");
                String cpf = scanner.nextLine();
                System.out.print("Digite o nome do cliente: ");
                String nome = scanner.nextLine();

                Cliente cliente = new Cliente(nome, cpf);
                cadastrarCliente.cadastrar(cliente);
                System.out.println("Cliente Pessoa Física cadastrado com sucesso!");

            } else if (tipoCliente.equalsIgnoreCase("PJ")) {
                System.out.print("Digite o CNPJ do cliente: ");
                String cnpj = scanner.nextLine();
                System.out.print("Digite o nome do cliente: ");
                String nome = scanner.nextLine();
                Cliente cliente = new Cliente(nome, cnpj);
                cadastrarCliente.cadastrar(cliente);
                System.out.println("Cliente Pessoa Jurídica cadastrado com sucesso!");
            } else {
                System.out.println("Tipo de cliente inválido.");
            }
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
