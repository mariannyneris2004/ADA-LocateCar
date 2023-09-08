package repository;

import java.util.List;

public interface Repository {
    Object cadastrar(Object object);

    Object alterar(Object object);

    List<Object> buscarLista();

    Object buscar();

    boolean deletar(Object object);
}
