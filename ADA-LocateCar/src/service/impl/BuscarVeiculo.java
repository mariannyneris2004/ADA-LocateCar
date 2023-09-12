package service.impl;

import exceptions.ObjetoNaoEncontradoException;
import model.Veiculo;
import repository.VeiculoRepository;

import java.util.HashMap;
import java.util.Map;

public class BuscarVeiculo implements service.api.BuscarVeiculo {
    VeiculoRepository repository;

    public BuscarVeiculo(VeiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Veiculo buscarPorPlaca(String placa) {
        if (repository.buscar(placa) == null){
            throw new ObjetoNaoEncontradoException("Veículo não encontrado!");
        } else {
            return repository.buscar(placa);
        }
    }

    @Override
    public Map<String, Veiculo> veiculos(){
        if (repository.buscarLista().isEmpty()){
            throw new ObjetoNaoEncontradoException("Nenhum veículo cadastrado!");
        } else {
            return repository.buscarLista();
        }
    }

    @Override
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
