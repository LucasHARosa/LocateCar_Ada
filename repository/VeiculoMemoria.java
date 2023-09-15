package repository;

import model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoMemoria  implements Repository<Veiculo>{
    private static List<Veiculo> veiculos = new ArrayList<>();
    @Override
    public void add(Veiculo item) {
        veiculos.add(item);
    }

    @Override
    public void remove(Veiculo item) {
        veiculos.remove(item);
    }

    @Override
    public void update(Veiculo anterior, Veiculo novo) {

    }

    @Override
    public Veiculo get(String id) {
        return veiculos.stream().filter(veiculo -> veiculo.getPlaca().equals(id)).findFirst().get();
    }

    public List<Veiculo> getAll() {
        return veiculos;
    }
}
