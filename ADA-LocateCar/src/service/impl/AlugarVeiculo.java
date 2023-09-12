package service.impl;

import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoCadastradoException;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import repository.AluguelRepository;
import service.api.Alugar;

import java.util.Scanner;

public class AlugarVeiculo implements Alugar {
    private AluguelRepository repository;

    public AlugarVeiculo(AluguelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Aluguel alugarVeiculo(Aluguel aluguel) {
        if (repository.buscarPorClienteEVeiculo(aluguel.getCliente(), aluguel.getVeiculo(),
                aluguel.getData()) == null){
            repository.alugar(aluguel);
            return aluguel;
        } else {
            throw new ObjetoCadastradoException("Veículo já alugado!");
        }
    }
}
