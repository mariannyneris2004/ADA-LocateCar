package service;

import model.Veiculo;
import repository.VeiculoRepository;

public class AlterarVeiculo {
    VeiculoRepository repository;

    public AlterarVeiculo(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo alterar(Veiculo veiculo) {
        repository.cadastrar(veiculo);
        return veiculo;
    }
}
