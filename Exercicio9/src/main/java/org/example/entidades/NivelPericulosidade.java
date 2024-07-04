package org.example.entidades;

public enum NivelPericulosidade {
    BAIXO("Baixo"),
    MEDIO("Médio"),
    ALTO("Alto");

    private String descricao;

    NivelPericulosidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
