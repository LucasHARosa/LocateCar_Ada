package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteMemoria implements Repository<Cliente>{
    private static List<Cliente> clientes = new ArrayList<>();

    @Override
    public void add(Cliente item) {
        clientes.add(item);
    }

    @Override
    public void remove(Cliente item) {
        clientes.remove(item);
    }

    @Override
    public void update(Cliente anterior, Cliente novo) {
        // Trocar o cliente anterior pelo novo

    }

    @Override
    public Cliente get(String id) {
        return clientes.stream().filter(cliente -> cliente.getDocumento().getValor().equals(id)).findFirst().get();
    }

    @Override
    public List<Cliente> getAll() {
        return clientes;
    }
}
