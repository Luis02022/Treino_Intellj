package com.example.treino.treinamento._5.model;

public enum TipoPlano {
    BASICO("Basico"),
    PREMIUM("Premium"),
    VIP("Vip");


    private String descricao;

    TipoPlano(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
