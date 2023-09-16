package service.impl;

import model.Aluguel;
import model.DataLocal;
import model.Valor;
import repository.Repository;
import service.api.ListaObjetos;
import utils.CalculaValor;
import utils.Input;
import utils.InputDataLocal;

import java.time.LocalDateTime;

public class Devolucao {
    private Repository<Aluguel> alugueis;

    public Devolucao(Repository<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }
    public void execute() {
        if(!alugueisNaoFinalizados()){
            System.out.println("Não existem alugueis abertos.");
            return;
        }
        Aluguel aluguel = selecionarAluguel();

        LocalDateTime dataSaida = InputDataLocal.lerDataHora("Data e hora de devolução do veiculo. Formato (10/02/2023 13:30): ");
        String local = Input.lerString("Local de devolução do veiculo: ");
        aluguel.setDataLocalSaida(new DataLocal(dataSaida, local));
        double dias = utils.CalculaDiarias.execute(aluguel.getDataLocalEntrada().getDataHora(),
                aluguel.getDataLocalSaida().getDataHora());
        Valor valor = CalculaValor.execute(dias, aluguel.getVeiculo().getTipo().getDescricao(), aluguel.getCliente().getDocumento());
        aluguel.setValores(valor);
        alugueis.update(aluguel);

        System.out.println();
        System.out.println("Resumo do aluguel:");
        print(aluguel);

    }

    private void print(Aluguel aluguel){
        System.out.println("Cliente: " + aluguel.getCliente().getNome());
        System.out.println("Veículo: "+ aluguel.getVeiculo().getTipo().getDescricao());
        System.out.println("Marca: "+aluguel.getVeiculo().getMarca());
        System.out.println("Placa: "+ aluguel.getVeiculo().getPlaca());
        System.out.println("Data de início: "+ aluguel.getDataLocalEntrada().getDataHora());
        System.out.println("Data de devolução: "+ aluguel.getDataLocalSaida().getDataHora());
        System.out.println("Valor Bruto: R$"+ aluguel.getValores().getValorBruto());
        System.out.println("Valor do desconto: R$"+ aluguel.getValores().getValorDesconto());
        System.out.println("Valor total: R$"+ aluguel.getValores().getValorTotal());
    }

    private boolean existemAlugueis(){
        return alugueis.getAll().size() > 0;
    }
     private Aluguel selecionarAluguel() {
         ListaObjetos<Aluguel> listaAlugueis = new SelecionarAluguel();
         Aluguel aluguel = listaAlugueis.selecionar(alugueis.getAll());
         if(aluguel.getValores().getValorTotal()!=0){
             System.out.println("Aluguel já finalizado.");
             return selecionarAluguel();
         }
         return aluguel;
     }

     private boolean alugueisNaoFinalizados(){
        if(!existemAlugueis()) {
            return false;
        }
         for(Aluguel aluguel : alugueis.getAll()){
             if(aluguel.getValores().getValorBruto() == 0){
                 return true;
             }
         }
         return false;
     }

}
