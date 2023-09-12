package service.api;

import model.Cliente;
import model.Veiculo;
import service.impl.BuscarAluguel;

public interface Devolver {
    double devolverVeiculo(service.api.BuscarAluguel buscarAluguel, Cliente cliente, Veiculo veiculo,
                           String dataAluguel, String horaAluguel, String dataDevolucao,
                           String horaDevolucao, String local);
}
