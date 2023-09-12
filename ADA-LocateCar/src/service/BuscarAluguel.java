package service;

import exceptions.ObjetoNaoEncontradoException;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import repository.AluguelRepository;

import java.util.HashMap;
import java.util.Map;

public class BuscarAluguel {
    AluguelRepository repository;

    public BuscarAluguel(AluguelRepository repository) {
        this.repository = repository;
    }

    public Aluguel buscarPorId(int id) {
        if (repository.buscarPorId(id) == null){
            throw new ObjetoNaoEncontradoException("Aluguel não encontrado!");
        } else {
            return repository.buscarPorId(id);
        }
    }

    public Map<Integer, Aluguel> alugueis(){
        if (repository.buscarLista().isEmpty()){
            throw new ObjetoNaoEncontradoException("Nenhum aluguel efetuado!");
        } else {
            return repository.buscarLista();
        }
    }

    public Aluguel buscarPorClienteEVeiculo(Cliente cliente, Veiculo veiculo, String dataAtual){
        return repository.buscarPorClienteEVeiculo(cliente, veiculo, dataAtual);
    }
}
