package service.impl;

import model.TipoVeiculo;
import model.Veiculo;
import repository.Repository;
import service.api.Cadastrar;
import utils.Input;

public class CadastrarVeiculo implements Cadastrar {
    public Repository<Veiculo> veiculos;

    public CadastrarVeiculo(Repository<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    @Override
    public void cadastrar() {
        for(int i =1; i<= TipoVeiculo.values().length; i++){
            System.out.println(i + " - " + TipoVeiculo.values()[i-1].getDescricao());
        }
        int opcao = Input.lerInt("Digite o número correspondente ao tipo de veículo: ");
        if(opcao < 1 || opcao > TipoVeiculo.values().length){
            System.out.println("Opção inválida.");
            return;
        }
        TipoVeiculo tipoVeiculo = TipoVeiculo.values()[opcao-1];
        String marca = Input.lerString("Digite a marca do veículo: ");
        String placa = Input.lerString("Digite a placa do veículo: ");
        if(cadastroExiste(placa)){
            System.out.println("Veículo já cadastrado.");
            return;
        }
        veiculos.add(new Veiculo(tipoVeiculo, marca, placa));
        System.out.println("Veículo cadastrado com sucesso.");
    }

    @Override
    public boolean cadastroExiste(String valor) {
        return veiculos.getAll().stream().anyMatch(veiculo -> veiculo.getPlaca().equals(valor));
    }

}
