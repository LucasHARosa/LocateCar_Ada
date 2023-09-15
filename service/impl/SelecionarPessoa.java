package service.impl;

import model.Cliente;
import service.api.ListaObjetos;
import utils.Input;

import java.util.List;

public class SelecionarPessoa implements ListaObjetos<Cliente> {
    @Override
    public Cliente selecionar(List<Cliente> lista) {
        listar(lista);
        int opcao = Input.lerInt("Digite o número correspondente ao cliente: ");
        if(opcao < 1 || opcao > lista.size()){
            System.out.println("Opção inválida.");
            return selecionar(lista);
        }
        return lista.get(opcao-1);
    }

    @Override
    public void listar(List<Cliente> lista) {
        System.out.println();
        System.out.println("Clientes:");
        int index = 1;
        for (Cliente cliente : lista) {
            System.out.println(index + " - Nome: " + cliente.getNome() + "; "+ cliente.getDocumento().getTipo().getDescricao() +": "+ cliente.getDocumento().getValor());
            index++;
        }
    }

}
