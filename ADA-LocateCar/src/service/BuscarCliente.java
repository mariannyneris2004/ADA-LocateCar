package service;

import model.Cliente;
import repository.ClienteRepository;

import java.util.HashMap;
import java.util.Map;

public class BuscarCliente {
    ClienteRepository repository;

    public BuscarCliente(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente buscarPorId(Integer id) {
        return repository.buscarPorId(id);
    }

    public Map<Integer, Cliente> clientes(){
        return repository.buscarLista();
    }

    public Map<Integer, Cliente> buscarPorNome(String nome){
        Map<Integer, Cliente> clientes = new HashMap<>();
        for (Cliente cliente:clientes().values()) {
            if (cliente.getNome().toUpperCase().contains(nome.toUpperCase())){
                clientes.put(cliente.getId(), cliente);
            }
        }
        return clientes;
    }

    public Cliente buscarClientePorDocumento(String documento) {
        for (Cliente cliente : clientes().values()) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }
}
