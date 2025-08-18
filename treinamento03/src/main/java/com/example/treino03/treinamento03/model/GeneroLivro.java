package com.example.treino03.treinamento03.model;

public enum GeneroLivro {
    ROMANCE("Romance"),
    FICCAO("Ficção"),
    HISTORIA("História");


    private String descricao;

    GeneroLivro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
