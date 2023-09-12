package service.impl;

import exceptions.ObjetoNaoEncontradoException;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import repository.AluguelRepository;


public class BuscarAluguel implements service.api.BuscarAluguel {
    AluguelRepository repository;

    public BuscarAluguel(AluguelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Aluguel buscarPorClienteEVeiculo(Cliente cliente, Veiculo veiculo, String dataAtual){
        if (repository.buscarPorClienteEVeiculo(cliente, veiculo, dataAtual) != null){
            return repository.buscarPorClienteEVeiculo(cliente, veiculo, dataAtual);
        }
        throw new ObjetoNaoEncontradoException("Aluguel não encontrado!");
    }
}
