package service.api;

import model.Cliente;

public interface CadastrarCliente extends Cadastrar{
    Cliente cadastrar(Cliente cliente);
}
