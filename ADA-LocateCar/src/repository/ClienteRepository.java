package repository;

import model.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteRepository {
    private Map<Integer, Cliente> clientes = new HashMap<>();
    private int ultimoId = 0;

    public Cliente cadastrar(Cliente cliente) {
        ultimoId++;
        cliente.setId(ultimoId);
        this.clientes.put(ultimoId, cliente);
        return cliente;
    }

    public Cliente alterar(Cliente cliente) {
        if(buscarPorId(cliente.getId()) != null){
            clientes.replace(cliente.getId(), cliente);
        }
        return null;
    }

    public Map<Integer, Cliente> buscarLista() {
        return this.clientes;
    }

    public Cliente buscarPorDocumento(String documento) {
        for (Cliente cliente:clientes.values()) {
            if (cliente.getDocumento().equals(documento)) {
                return clientes.get(cliente.getId());
            }
        }
        return null;
    }
    public Cliente buscarPorId(Integer id) {
        return clientes.get(id);
    }

}
