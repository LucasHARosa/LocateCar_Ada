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
            System.out.println("Cadastre mais um cliente antes de alugar um veículo.");
            return;
        }
        if(!existemVeiculos()){
            System.out.println("Não existem veículos disponíveis");
            return;
        }
        Cliente cliente = selecionarCliente();
        Veiculo veiculo = selecionarVeiculo();
        LocalDateTime dataEntrada = InputDataLocal.lerDataHora("Data e hora de retirada do veiculo. Formato (10/02/2023 13:30): ");
        String local = Input.lerString("Local de retirada do veiculo: ");
        DataLocal dataLocal = new DataLocal(dataEntrada, local);
        veiculos.update(veiculo);
        alugueis.add(new Aluguel(cliente, veiculo, dataLocal));
        System.out.println("Aluguel cadastrado com sucesso.");
    }

    @Override
    public boolean cadastroExiste(String valor) {

        for(Aluguel aluguel : alugueis.getAll()){
            if(aluguel.getCliente().getDocumento().getValor().equals(valor)){
                return true;
            }
        }
        return false;
    }

    public Veiculo selecionarVeiculo(){
        ListaObjetos<Veiculo> listaVeiculos = new SelecionarVeiculo();
        Veiculo veiculo = listaVeiculos.selecionar(veiculos.getAll());
        if(!veiculo.isDisponivel()){
            System.out.println("Veículo já alugado. Por favor selecione outro veículo.");
            return selecionarVeiculo();
        }
        return veiculo;
    }

    public Cliente selecionarCliente(){
        ListaObjetos<Cliente> listaClientes = new SelecionarPessoa();
        Cliente cliente = listaClientes.selecionar(clientes.getAll());
        if(cadastroExiste(cliente.getDocumento().getValor())){
            System.out.println("Cliente já possui aluguel em aberto. Por favor selecione outro cliente.");
            selecionarCliente();
        }
        return cliente;
    }

    public boolean existemClientes() {
        if(clientes.getAll().isEmpty()){
            return false;
        }
        else{
            for(Cliente cliente : clientes.getAll()){
                if(!cadastroExiste(cliente.getDocumento().getValor())){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean existemVeiculos() {
        if(veiculos.getAll().isEmpty()){
            return false;
        }
        else{
            for(Veiculo veiculo : veiculos.getAll()){
                if(veiculo.isDisponivel()){
                    return true;
                }
            }
        }
        return false;
    }


}
