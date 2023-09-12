package service.api;

import model.Aluguel;
import model.Cliente;
import model.Veiculo;

public interface BuscarAluguel extends Buscar{
    Aluguel buscarPorClienteEVeiculo(Cliente cliente, Veiculo veiculo, String dataAtual);
}
