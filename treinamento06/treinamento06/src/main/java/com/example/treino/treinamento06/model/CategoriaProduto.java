package com.example.treino.treinamento06.model;

public enum CategoriaProduto {
    ELETRONICO("Eletronico"),
    ROUPA("Roupa"),
    ALIMENTO("Alimento");

    private String descricao;

    CategoriaProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
