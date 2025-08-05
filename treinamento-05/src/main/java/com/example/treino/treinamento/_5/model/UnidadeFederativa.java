package com.example.treino.treinamento._5.model;

public enum UnidadeFederativa {
    RS("Rio Grande do Sul", "RS"),
    BA("Bahia", "BA"),
    SC("Santa Catarina", "SC");


    private String nome;
    private String sigla;

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
