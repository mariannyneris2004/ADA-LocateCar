package service.api;

import model.Veiculo;

public interface CadastrarVeiculo extends Cadastrar{
    Veiculo cadastrar(Veiculo veiculo);
}
