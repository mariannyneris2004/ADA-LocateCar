package service;

import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import repository.AluguelRepository;

public class DevolverVeiculo {
    AluguelRepository repository;

    public DevolverVeiculo(AluguelRepository repository) {
        this.repository = repository;
    }

    public double devolverVeiculo(BuscarAluguel buscarAluguel, Cliente cliente, Veiculo veiculo,
                                  String dataAluguel, String horaAluguel, String dataDevolucao,
                                  String horaDevolucao, String local) {
        Aluguel aluguel = buscarAluguel.buscarPorClienteEVeiculo(cliente, veiculo, dataAluguel);
        String tipoCarro = veiculo.getTipo().getTipo();

        aluguel.setLocal(local);
        aluguel.setDataDevolucao(dataDevolucao);
        aluguel.setHoraDevolucao(horaDevolucao);

        repository.devolver(aluguel);

        double valorAPagar = CalcularAluguel.calcularValorAluguel(tipoCarro, dataAluguel, dataDevolucao, horaAluguel, horaDevolucao,
                cliente);

        return valorAPagar;
    }
}
