/*
package service;

import model.Aluguel;
import model.Cliente;
import model.Veiculo;

import java.util.Scanner;

public class AlugarVeiculo {
    private static void alugarVeiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo que deseja alugar: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if (veiculo != null) {
            if (veiculo.isDisponivel()) {
                System.out.print("Digite o ID do cliente (CPF ou CNPJ): ");
                String idCliente = scanner.nextLine();
                Cliente cliente = buscarClientePorId(idCliente);

                if (cliente != null) {
                    System.out.print("Digite a data do aluguel (dd/mm/aaaa): ");
                    String dataAluguel = scanner.nextLine();
                    System.out.print("Digite o número de horas do aluguel: ");
                    int horasAlugadas = scanner.nextInt();

                    veiculo.setDisponivel(false);
                    Aluguel aluguel = new Aluguel(veiculo, cliente, dataAluguel, horasAlugadas);
                    alugueis.add(aluguel);
                    System.out.println("Veículo alugado com sucesso!");
                } else {
                    System.out.println("Cliente não encontrado.");
                }
            } else {
                System.out.println("O veículo não está disponível para aluguel.");
            }
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }
}
*/
