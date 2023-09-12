package service.impl;

import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoCadastradoException;
import model.Cliente;
import repository.ClienteRepository;

public class CadastrarCliente implements service.api.CadastrarCliente {
    ClienteRepository repository;

    public CadastrarCliente(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente cadastrar(Cliente cliente) {
        if (repository.buscarPorDocumento(cliente.getDocumento()) != null){
            throw new ObjetoCadastradoException("Cliente já cadastrado!");
        } else if(cliente.getDocumento().length() != 11 && cliente.getDocumento().length() != 14){
            throw new ArgumentoInvalidoException("Documento inválido!");
        } else if (cliente.getNome().isEmpty()) {
            throw new ArgumentoInvalidoException("O nome do cliente não pode ser vazio!");
        } else {
            repository.cadastrar(cliente);
            return cliente;
        }
    }
}
