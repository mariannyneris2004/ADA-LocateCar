package service;

import model.Cliente;
import repository.ClienteRepository;

public class CadastrarCliente {
    ClienteRepository repository;

    public CadastrarCliente(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrar(Cliente cliente) {
        if((cliente.getDocumento().length() == 11 || cliente.getDocumento().length() == 14)
            && !cliente.getNome().isEmpty()){
            repository.cadastrar(cliente);
            return cliente;
        }
        return null;
    }
}
