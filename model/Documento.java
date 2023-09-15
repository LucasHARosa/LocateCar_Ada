package model;

public class Documento {
    private TipoDocumento tipo;
    private String valor;

    public Documento(TipoDocumento tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
