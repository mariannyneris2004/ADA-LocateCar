package service;

import exceptions.ObjetoNaoEncontradoException;
import model.Veiculo;
import repository.VeiculoRepository;

public class AlterarVeiculo {
    VeiculoRepository repository;

    public AlterarVeiculo(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo alterar(Veiculo veiculo) {
        if (repository.buscar(veiculo.getPlaca()) == null){
            throw new ObjetoNaoEncontradoException("Veículo não encontrado!");
        } else {
            repository.alterar(veiculo);
            return veiculo;
        }
    }
}
