package service.impl;

import model.Cliente;
import utils.ContagemHoras;

public class CalcularAluguel {
    public static double calcularValorAluguel(String tipoVeiculo, String dataInicial, String dataFinal,
                                               String horaAluguel, String horaDevolucao, Cliente cliente) {
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

        int horasAlugadas = ContagemHoras.contagemHoras(dataInicial, dataFinal, horaAluguel, horaDevolucao);
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
