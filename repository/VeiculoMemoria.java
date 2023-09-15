package repository;

import model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoMemoria  implements Repository<Veiculo>{
    private static final List<Veiculo> veiculos = new ArrayList<>();
    @Override
    public void add(Veiculo item) {
        veiculos.add(item);
    }

    @Override
    public void remove(Veiculo item) {
        veiculos.remove(item);
    }

    @Override
    public void update(Veiculo update) {
        for(Veiculo veiculo : veiculos){
            if(veiculo.getPlaca().equals(update.getPlaca())){
                veiculo.setDisponivel(!update.isDisponivel());
            }
        }
    }

    @Override
    public Veiculo get(String id) {
        return veiculos.stream().filter(veiculo -> veiculo.getPlaca().equals(id)).findFirst().get();
    }

    public List<Veiculo> getAll() {
        return veiculos;
    }
}
