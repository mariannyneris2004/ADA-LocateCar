package service;

import exceptions.ObjetoNaoEncontradoException;
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
        if (repository.buscar(placa) != null){
            return repository.buscar(placa);
        } else {
            throw new ObjetoNaoEncontradoException("Veículo não encontrado!");
        }
    }

    public Map<String, Veiculo> veiculos(){
        if (repository.buscarLista().isEmpty()){
            throw new ObjetoNaoEncontradoException("Nenhum veículo encontrado!");
        } else {
            return repository.buscarLista();
        }
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
