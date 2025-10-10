package com.example.treino.treinamento06.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tab_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "pedido_produto", // nome da tabela intermediária
            joinColumns = @JoinColumn(name = "pedido_id"), // chave estrangeira do Pedido
            inverseJoinColumns = @JoinColumn(name = "produto_id") // chave estrangeira do Produto
    )
    private List<Produto> produtos;


    public Pedido() {
    }

    public Pedido(Long numeroPedido, Cliente cliente, List<Produto> produtos) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
