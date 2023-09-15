package service.impl;

import model.Cliente;
import model.Documento;
import model.TipoDocumento;
import repository.Repository;
import service.api.Cadastrar;
import utils.Input;

public class CadastrarCliente implements Cadastrar {
    private Repository<Cliente> clientes;
    public CadastrarCliente(Repository<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void cadastrar() {
        String nome = Input.lerString("Digite o nome do cliente: ");
        Documento documento = tipoDocumento();
        if(cadastroExiste(documento.getValor())){
            System.out.println("Cliente já cadastrado.");
            return;
        }
        clientes.add(new Cliente(nome, documento));
        System.out.println("Cliente cadastrado com sucesso");
    }

    @Override
    public boolean cadastroExiste(String valor) {
        if(clientes.getAll().isEmpty() || clientes == null){
            return false;
        }
        return clientes.getAll().stream().anyMatch(cliente -> cliente.getDocumento().getValor().equals(valor));
    }

    private Documento tipoDocumento() {
        for(int i = 1; i <= TipoDocumento.values().length; i++){
            System.out.println(i + " - " + TipoDocumento.values()[i-1].getDescricao());
        }
        int opcao = Input.lerInt("Digite o número correspondente ao tipo de documento: ");
        if(opcao < 1 || opcao > TipoDocumento.values().length){
            System.out.println("Opção inválida.");
            return tipoDocumento();
        }
        TipoDocumento tipoDocumento = TipoDocumento.values()[opcao-1];
        String valorDocumento = Input.lerString("Digite o número do "+ tipoDocumento.getDescricao() +": ");
        Documento documento = new Documento(tipoDocumento, valorDocumento);
        return documento;
    }
}
