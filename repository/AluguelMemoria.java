package repository;

import model.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class AluguelMemoria implements Repository<Aluguel>
{
    private static final List<Aluguel> alugueis = new ArrayList<>();

    @Override
    public void add(Aluguel item) {
        alugueis.add(item);
    }

    @Override
    public void remove(Aluguel item) {
        alugueis.remove(item);
    }

    @Override
    public void update(Aluguel update) {
        for(Aluguel aluguel : alugueis){
            if(aluguel.getCliente().getDocumento().getValor().equals(update.getCliente().getDocumento().getValor())){
                aluguel.setValores(update.getValores());
                aluguel.setDataLocalSaida(update.getDataLocalSaida());
            }
        }
    }

    @Override
    public Aluguel get(String id) {
        return alugueis.stream().filter(aluguel -> aluguel.getCliente().getDocumento().getValor().equals(id)).findFirst().get();
    }

    @Override
    public List<Aluguel> getAll() {
        return alugueis;
    }
}
