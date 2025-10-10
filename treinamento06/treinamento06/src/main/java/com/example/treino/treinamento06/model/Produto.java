package com.example.treino.treinamento06.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tab_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private double preco;

    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoriaProduto;

    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos = new ArrayList<>();

    public Produto() {
    }

    public Produto(Long id, String nome, double preco, CategoriaProduto categoriaProduto, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoriaProduto = categoriaProduto;
        this.pedidos = pedidos;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
