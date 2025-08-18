package com.example.treino03.treinamento03.model;

public enum UnidadeFederativa {
    SP("São Paulo", "SP"),
    RJ("Rio de Janeiro", "RJ"),
    MG("Minas Gerais", "MG");


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
