package model;

public enum TipoVeiculo {
    SUV("SUV"),
    SEDAN("SEDAN"),
    HATCH("HATCH"),
    PICKUP("PICKUP");

    private final String descricao;

    TipoVeiculo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
