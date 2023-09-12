package service.impl;

import exceptions.ArgumentoInvalidoException;
import model.Cliente;
import repository.ClienteRepository;

public class AlterarCliente implements service.api.AlterarCliente {
    ClienteRepository repository;
    public AlterarCliente(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void alterar(Cliente obj) {
        if(obj.getDocumento().length() != 11 && obj.getDocumento().length() != 14){
            throw new ArgumentoInvalidoException("Documento inválido!");
        } else if (obj.getNome().isEmpty()) {
            throw new ArgumentoInvalidoException("O nome do cliente não pode ser vazio!");
        } else {
            repository.alterar(obj);
        }
    }
}
