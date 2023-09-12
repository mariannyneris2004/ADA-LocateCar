package service.impl;

import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoCadastradoException;
import model.Veiculo;
import repository.VeiculoRepository;

public class CadastrarVeiculo implements service.api.CadastrarVeiculo {
    VeiculoRepository repository;

    public CadastrarVeiculo(VeiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Veiculo cadastrar(Veiculo veiculo) {
        if(repository.buscar(veiculo.getPlaca()) != null){
            throw new ObjetoCadastradoException("Veículo já cadastrado!");
        } else if (veiculo.getPlaca().isEmpty()) {
            throw new ArgumentoInvalidoException("A placa não pode ser vazia!");
        } else {
            repository.cadastrar(veiculo);
            return veiculo;
        }
    }
}
