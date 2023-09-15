package model;

public class Aluguel {
    private Cliente cliente;
    private Veiculo veiculo;
    private DataLocal dataLocalEntrada;
    private DataLocal dataLocalSaida;

    private Valor valores;

    public Aluguel(Cliente cliente, Veiculo veiculo, DataLocal dataLocalEntrada) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataLocalEntrada = dataLocalEntrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public DataLocal getDataLocalEntrada() {
        return dataLocalEntrada;
    }

    public void setDataLocalEntrada(DataLocal dataLocalEntrada) {
        this.dataLocalEntrada = dataLocalEntrada;
    }

    public DataLocal getDataLocalSaida() {
        return dataLocalSaida;
    }

    public void setDataLocalSaida(DataLocal dataLocalSaida) {
        this.dataLocalSaida = dataLocalSaida;
    }

    public Valor getValores() {
        return valores;
    }

    public void setValores(Valor valores) {
        this.valores = valores;
    }
}
