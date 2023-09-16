package service.impl;

import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import repository.Repository;
import service.api.Cadastrar;
import service.api.ListaObjetos;

public class LocateCar {
    public Repository<Cliente> clientes;
    public Repository<Veiculo> veiculos;
    public Repository<Aluguel> alugueis;
    public LocateCar(Repository<Cliente> clientes, Repository<Veiculo> veiculos, Repository<Aluguel> alugueis) {
        this.clientes = clientes;
        this.veiculos = veiculos;
        this.alugueis = alugueis;
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
                cadastrarVeiculo();
                break;
            case 3:
                alugarVeiculo();
                break;
            case 4:
                new Devolucao(alugueis).execute();
                break;
            case 5:
                listarClientes();
                break;
            case 6:
                listarVeiculos();
                break;
            case 7:
                listarAlugueis();
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

    public void alugarVeiculo() {
        System.out.println();
        Cadastrar alugarVeiculo = new CadastrarAluguel(alugueis,clientes, veiculos);
        alugarVeiculo.cadastrar();
    }

    public void listarClientes() {
        ListaObjetos<Cliente> listaClientes = new SelecionarPessoa();
        listaClientes.listar(clientes.getAll());

    }

    public void listarVeiculos() {
        ListaObjetos<Veiculo> listaVeiculos = new SelecionarVeiculo();
        listaVeiculos.listar(veiculos.getAll());
    }

    public void listarAlugueis() {
        ListaObjetos<Aluguel> listaAlugueis = new SelecionarAluguel();
        listaAlugueis.listar(alugueis.getAll());
    }
}
