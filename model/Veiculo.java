package model;

public class Veiculo {
    private String placa;
    private TipoVeiculo tipo;
    private String marca;
    private boolean disponivel = true;


    public Veiculo(TipoVeiculo tipo,String marca,String placa) {
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
