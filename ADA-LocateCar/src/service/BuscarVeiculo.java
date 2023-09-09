package service;

import model.Veiculo;
import repository.VeiculoRepository;

import java.util.HashMap;
import java.util.Map;

public class BuscarVeiculo {
    VeiculoRepository repository;

    public BuscarVeiculo(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo buscarPorPlaca(String placa) {
        return repository.buscar(placa);
    }

    public Map<String, Veiculo> veiculos(){
        return repository.buscarLista();
    }

    public Map<String, Veiculo> buscarPorModelo(String modelo){
        Map<String, Veiculo> veiculos = new HashMap<>();
        for (Veiculo veiculo:veiculos().values()) {
            if (veiculo.getModelo().toUpperCase().contains(modelo.toUpperCase())){
                veiculos.put(veiculo.getPlaca(), veiculo);
            }
        }
        return veiculos;
    }
}
