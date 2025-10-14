package com.example.treino.treinamento._5.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String cpf;
    private String datNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Aluno() {
    }

    @Enumerated(EnumType.STRING)
    private Plano plano;


    public Aluno(Long id, String nome, String cpf, String datNascimento, Endereco endereco, Plano plano) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.datNascimento = datNascimento;
        this.endereco = endereco;
        this.plano = plano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDatNascimento() {
        return datNascimento;
    }

    public void setDatNascimento(String datNascimento) {
        this.datNascimento = datNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
