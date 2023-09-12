package service;

import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoNaoEncontradoException;
import model.Cliente;
import repository.ClienteRepository;

public class AlterarCliente {
    ClienteRepository repository;
    public AlterarCliente(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente alterar(Cliente cliente) {
        if(cliente.getDocumento().length() != 11 && cliente.getDocumento().length() != 14){
            throw new ArgumentoInvalidoException("Documento inválido!");
        } else if (cliente.getNome().isEmpty()) {
            throw new ArgumentoInvalidoException("O nome do cliente não pode ser vazio!");
        } else {
            repository.alterar(cliente);
            return cliente;
        }
    }
}
