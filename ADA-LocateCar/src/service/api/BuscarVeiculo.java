package service.api;

import model.Cliente;
import model.Veiculo;

import java.util.Map;

public interface BuscarVeiculo extends Buscar{

    Veiculo buscarPorPlaca(String placa);
    Map<String, Veiculo> veiculos();
    Map<String, Veiculo> buscarPorModelo(String modelo);
}
