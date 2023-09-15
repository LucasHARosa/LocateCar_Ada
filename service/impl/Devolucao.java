package service.impl;

import model.Aluguel;
import repository.Repository;
import service.api.ListaObjetos;

public class Devolucao {
    private Repository<Aluguel> alugueis;

    public void execute() {
        ListaObjetos<Aluguel> listaAlugueis = new SelecionarAluguel();
        Aluguel aluguel = listaAlugueis.selecionar(alugueis.getAll());

    }
}
