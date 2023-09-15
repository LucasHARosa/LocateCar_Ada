package service.impl;

import model.Aluguel;
import service.api.ListaObjetos;
import utils.Input;

import java.util.List;

public class SelecionarAluguel implements ListaObjetos<Aluguel> {
    @Override
    public Aluguel selecionar(List<Aluguel> lista) {
        listar(lista);
        int opcao = Input.lerInt("Digite o número correspondente ao aluguel: ");
        return lista.get(opcao-1);
    }

    @Override
    public void listar(List<Aluguel> lista) {
        System.out.println();
        System.out.println("Aluguéis:");
        int index = 1;
        for (Aluguel aluguel : lista) {
            System.out.println(index + " - Cliente: " + aluguel.getCliente().getNome() + "; Veículo: "+ aluguel.getVeiculo().getTipo().getDescricao() + "; Marca: "+aluguel.getVeiculo().getMarca()+"; Placa: "+ aluguel.getVeiculo().getPlaca() + "; Data de início: "+ aluguel.getDataLocalEntrada().getDataHora() );
            index++;
        }
    }

    public void listarCompleto(List<Aluguel> lista){

    }
}
