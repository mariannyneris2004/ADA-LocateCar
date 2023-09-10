package views;

import exceptions.ArgumentoInvalidoException;
import utils.EntradaDeDados;

public class MenuView {
    public static int menu(){
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
        try {
            int opcao = EntradaDeDados.getInt();
            return opcao;
        } catch (RuntimeException e){
            throw new ArgumentoInvalidoException("Opção inválida!");
        }
    }
}
