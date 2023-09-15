import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import repository.AluguelMemoria;
import repository.ClienteMemoria;
import repository.Repository;
import repository.VeiculoMemoria;
import service.impl.LocateCar;

public class Main {

    public static void main(String[] args) {
        Repository<Cliente> repositoryCliente = new ClienteMemoria();
        Repository<Veiculo> repositoryVeiculo = new VeiculoMemoria();
        Repository<Aluguel> repositoryAluguel = new AluguelMemoria();
        LocateCar locateCar = new LocateCar(repositoryCliente, repositoryVeiculo, repositoryAluguel);
        boolean continua = true;
        System.out.println("Bem vindo ao LocateCar!");
        while(continua){
           continua = locateCar.execute();
        }

    }

}
