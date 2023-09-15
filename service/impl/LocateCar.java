package service.impl;

import model.Cliente;
import model.Veiculo;
import repository.Repository;
import service.api.Cadastrar;
import service.api.ListaObjetos;
import utils.Input;

public class LocateCar {
    public Repository<Cliente> clientes;
    public Repository<Veiculo> veiculos;
    public LocateCar(Repository<Cliente> clientes, Repository<Veiculo> veiculos) {
        this.clientes = clientes;
        this.veiculos = veiculos;
    }

    public boolean execute() {
        int opcao = MenuSeletor.execute();

        switch (opcao) {
            case 0:
                System.out.println("Saindo...");
                return false;
            case 1:
                cadastrarCliente();
                break;
            case 2:
                System.out.println("Cadastrar veículo.");
                break;
            case 3:
                listarClientes();
                break;
            case 4:
                System.out.println("Transferir.");
                break;
            default:
                MenuSeletor.tryAgain();
        }
        return true;
    }

    public void cadastrarCliente() {
        System.out.println();
        Cadastrar cadastrarCliente = new CadastrarCliente(clientes);
        cadastrarCliente.cadastrar();
    }

    public void cadastrarVeiculo() {
        System.out.println();
        Cadastrar cadastrarVeiculo = new CadastrarVeiculo(veiculos);
        cadastrarVeiculo.cadastrar();
    }

    public void listarClientes() {
        ListaObjetos listaClientes = new SelecionarPessoa();
        listaClientes.listar(clientes.getAll());

    }
}
