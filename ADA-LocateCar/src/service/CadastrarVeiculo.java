package service;

import model.Veiculo;
import repository.VeiculoRepository;

public class CadastrarVeiculo {
    VeiculoRepository repository;

    public CadastrarVeiculo(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo cadastrar(Veiculo veiculo) {
        repository.cadastrar(veiculo);
        return veiculo;
    }
}
