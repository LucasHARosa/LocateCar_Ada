package service.impl;

import model.Veiculo;
import service.api.ListaObjetos;
import utils.Input;

import java.util.List;

public class SelecionarVeiculo implements ListaObjetos<Veiculo> {

    @Override
    public Veiculo selecionar(List<Veiculo> lista) {
        listar(lista);
        int opcao = Input.lerInt("Digite o número correspondente ao veículo: ");
        return lista.get(opcao-1);
    }

    @Override
    public void listar(List<Veiculo> lista) {
        System.out.println();
        System.out.println("Veículos:");
        int index = 1;
        for (Veiculo veiculo : lista) {
            System.out.println(index + " - Tipo: " + veiculo.getTipo().getDescricao() + "; Marca: "+ veiculo.getMarca() +"; Placa: "+ veiculo.getPlaca()+"; Disponível: "+ veiculo.isDisponivel());
            index++;
        }
    }
}
