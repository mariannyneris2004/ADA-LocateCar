package service;

import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoCadastradoException;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import repository.AluguelRepository;

import java.util.Scanner;

public class AlugarVeiculo {
    private AluguelRepository repository;

    public AlugarVeiculo(AluguelRepository repository) {
        this.repository = repository;
    }

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
