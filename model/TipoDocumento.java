package model;

public enum TipoDocumento {
    CPF("CPF"),
    CNPJ("CNPJ"),
    RG("RG"),
    PASSAPORTE("PASSAPORTE"),
    CARTEIRA_DE_TRABALHO("CARTEIRA DE TRABALHO"),
    CARTEIRA_DE_MOTORISTA("CARTEIRA DE MOTORISTA");

    private final String descricao;

    TipoDocumento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
