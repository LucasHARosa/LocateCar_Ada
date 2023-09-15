package service.api;

import java.util.List;

public interface ListaObjetos<T> {

    T selecionar(List<T> lista);

    void listar(List<T> lista);
}
