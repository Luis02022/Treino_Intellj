package com.example.treino.treinamento06.model;

public enum UnidadeFederativa {
    DF("Distrito Federal", "DF"),
    GO("Goias", "GO"),
    TO("Tocantins", "TO");

    private String nome, sigla;

    UnidadeFederativa(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }
}
