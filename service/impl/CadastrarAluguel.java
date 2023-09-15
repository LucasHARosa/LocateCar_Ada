package service.impl;

import model.Aluguel;
import model.Cliente;
import model.DataLocal;
import model.Veiculo;
import repository.Repository;
import service.api.Cadastrar;
import service.api.ListaObjetos;
import utils.Input;
import utils.InputDataLocal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CadastrarAluguel implements Cadastrar {

    private Repository<Aluguel> alugueis;
    private Repository<Cliente> clientes;
    private Repository<Veiculo> veiculos;

    public CadastrarAluguel(Repository<Aluguel> alugueis, Repository<Cliente> clientes, Repository<Veiculo> veiculos) {
        this.alugueis = alugueis;
        this.clientes = clientes;
        this.veiculos = veiculos;
    }

    @Override
    public void cadastrar() {
        if(!existemClientes()){
            System.out.println("Não existem clientes cadastrados. Cadastre um cliente antes de alugar um veículo.");
            return;
        }
        if(!existemVeiculos()){
            System.out.println("Não existem veículos cadastrados. Cadastre um veículo antes de alugar um veículo.");
            return;
        }
        ListaObjetos<Cliente> listaClientes = new SelecionarPessoa();
        Cliente cliente = listaClientes.selecionar(clientes.getAll());
        Veiculo veiculo = selecionarVeiculo();
        LocalDateTime dataEntrada = InputDataLocal.lerDataHora("Data e hora de retirada do veiculo. Formato (10/02/2023 13:30): ");
        String local = Input.lerString("Local de retirada do veiculo: ");
        DataLocal dataLocal = new DataLocal(dataEntrada, local);
        if(cadastroExiste(cliente.getDocumento().getValor())){
            System.out.println("Cliente já possui aluguel em aberto. Por favor selecione outro cliente.");
            return;
        }
        veiculos.update(veiculo);
        alugueis.add(new Aluguel(cliente, veiculo, dataLocal));
        System.out.println("Aluguel cadastrado com sucesso.");
    }

    @Override
    public boolean cadastroExiste(String valor) {
        if(alugueis.getAll().isEmpty() || alugueis == null){
            return false;
        }
        return alugueis.getAll().stream().anyMatch(aluguel -> aluguel.getCliente().getDocumento().getValor().equals(valor));
    }

    public Veiculo selecionarVeiculo(){
        ListaObjetos<Veiculo> listaVeiculos = new SelecionarVeiculo();
        Veiculo veiculo = listaVeiculos.selecionar(veiculos.getAll());
        if(veiculo.isDisponivel()){
            System.out.println("Veículo já alugado. Por favor selecione outro veículo.");
            return selecionarVeiculo();
        }
        return veiculo;
    }

    public boolean existemClientes() {
        return !clientes.getAll().isEmpty();
    }

    public boolean existemVeiculos() {
        return !veiculos.getAll().isEmpty();
    }


}
