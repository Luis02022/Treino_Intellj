package com.example.treino.treinamento._5.model;

import jakarta.persistence.*;

public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double valorMensal;

    private int duracaoMeses;

    @Enumerated(EnumType.STRING)
    private TipoPlano tipoPlano;

    public Plano() {
    }

    public Plano(Long id, double valorMensal, int duracaoMeses, TipoPlano tipoPlano) {
        this.id = id;
        this.valorMensal = valorMensal;
        this.duracaoMeses = duracaoMeses;
        this.tipoPlano = tipoPlano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(int duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(TipoPlano tipoPlano) {
        this.tipoPlano = tipoPlano;
    }
}
