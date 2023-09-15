import repository.ClienteMemoria;
import repository.Repository;
import repository.VeiculoMemoria;
import service.impl.LocateCar;

public class Main {

    public static void main(String[] args) {
        Repository repositoryCliente = new ClienteMemoria();
        Repository repositoryVeiculo = new VeiculoMemoria();
        LocateCar locateCar = new LocateCar(repositoryCliente, repositoryVeiculo);
        boolean continua = true;
        System.out.println("Bem vindo ao LocateCar!");
        while(continua){
           continua = locateCar.execute();
        }

    }

}
