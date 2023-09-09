/*
package service;

import model.Aluguel;
import model.Cliente;
import model.Veiculo;

import java.util.Scanner;

public class DevolverVeiculo {
    private static void devolverVeiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do veículo que deseja devolver: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if (veiculo != null) {
            System.out.print("Digite o ID do cliente (CPF ou CNPJ): ");
            String idCliente = scanner.nextLine();
            Cliente cliente = buscarClientePorId(idCliente);

            if (cliente != null) {
                System.out.print("Digite a data da devolução (dd/mm/aaaa): ");
                String dataDevolucao = scanner.nextLine();

                for (Aluguel aluguel : alugueis) {
                    if (aluguel.getVeiculo().getPlaca().equals(placa) &&
                            aluguel.getCliente().getId().equals(idCliente) &&
                            aluguel.getData().equals(dataDevolucao)) {
                        int horasAlugadas = aluguel.getHorasAlugadas();
                        double valorTotal = calcularValorAluguel(horasAlugadas, veiculo.getTipo());
                        if (cliente.getId().length() == 11 && horasAlugadas > 5) {
                            valorTotal *= 0.95; // Desconto de 5% para cliente Pessoa Física com mais de 5 diárias
                        } else if (cliente.getId().length() == 14 && horasAlugadas > 3) {
                            valorTotal *= 0.90; // Desconto de 10% para cliente Pessoa Jurídica com mais de 3 diárias
                        }
                        veiculo.setDisponivel(true);
                        alugueis.remove(aluguel);
                        System.out.println("Veículo devolvido com sucesso.");
                        System.out.println("Valor do aluguel: R$ " + valorTotal);
                        return;
                    }
                }
                System.out.println("Aluguel não encontrado para o veículo e cliente informados.");
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }
}
*/
