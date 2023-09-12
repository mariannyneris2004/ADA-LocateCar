package service.impl;

import exceptions.ObjetoNaoEncontradoException;
import model.Veiculo;
import repository.VeiculoRepository;

public class AlterarVeiculo implements service.api.AlterarVeiculo {
    VeiculoRepository repository;

    public AlterarVeiculo(VeiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void alterar(Veiculo veiculo) {
        if (repository.buscar(veiculo.getPlaca()) == null){
            throw new ObjetoNaoEncontradoException("Veículo não encontrado!");
        } else {
            repository.alterar(veiculo);
        }
    }
}
