package views;

import exceptions.ArgumentoInvalidoException;
import model.Cliente;
import service.CadastrarCliente;
import utils.EntradaDeDados;

public class ClienteView {
    public static void cadastrarCliente(CadastrarCliente cadastrarCliente) {
        System.out.print("Digite o tipo de cliente (PF para Pessoa Física, PJ para Pessoa Jurídica): ");
        String tipoCliente = EntradaDeDados.getString();

        if (tipoCliente.equalsIgnoreCase("PF")) {
            System.out.print("Digite o CPF do cliente: ");
            String cpf = EntradaDeDados.getString();
            System.out.print("Digite o nome do cliente: ");
            String nome = EntradaDeDados.getString();

            Cliente cliente = new Cliente(nome, cpf);
            cadastrarCliente.cadastrar(cliente);
            System.out.println("Cliente Pessoa Física cadastrado com sucesso!");

        } else if (tipoCliente.equalsIgnoreCase("PJ")) {
            System.out.print("Digite o CNPJ do cliente: ");
            String cnpj = EntradaDeDados.getString();
            System.out.print("Digite o nome do cliente: ");
            String nome = EntradaDeDados.getString();
            Cliente cliente = new Cliente(nome, cnpj);
            cadastrarCliente.cadastrar(cliente);
            System.out.println("Cliente Pessoa Jurídica cadastrado com sucesso!");
        } else {
            throw new ArgumentoInvalidoException("Tipo de cliente inválido.");
        }
    }
}
