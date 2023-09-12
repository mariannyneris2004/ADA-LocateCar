package service.api;

import model.Cliente;

import java.util.Map;

public interface BuscarCliente extends Buscar{
    Map<Integer, Cliente> clientes();
    Map<Integer, Cliente> buscarPorNome(String nome);
    Cliente buscarClientePorDocumento(String documento);
}
