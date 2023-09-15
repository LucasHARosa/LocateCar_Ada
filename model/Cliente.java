package model;

import java.util.List;

public class Cliente {
    private String nome;
    private Documento documento;

    public Cliente(String nome, Documento documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(Documento documentos) {
        this.documento = documentos;
    }


}
