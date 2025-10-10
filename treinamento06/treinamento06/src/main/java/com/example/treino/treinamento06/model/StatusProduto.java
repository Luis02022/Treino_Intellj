package com.example.treino.treinamento06.model;

public enum StatusProduto {
    PENDENTE("Pendente"),
    ENVIADO("Enviado"),
    ENTREGUE("Entregue");

    private String descricao;

    StatusProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
