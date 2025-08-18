package com.example.treino03.treinamento03.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tab_livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotBlank(message = "Autor é obrigatório")
    private String autor;

    private int anoPublicacao;

    @Enumerated(EnumType.STRING)
    private GeneroLivro generoLivro;




    public Livro(Long isbn, String titulo, String autor, int anoPublicacao, GeneroLivro generoLivro) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.generoLivro = generoLivro;
    }

    public Livro() {
    }


    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public GeneroLivro getGeneroLivro() {
        return generoLivro;
    }

    public void setGeneroLivro(GeneroLivro generoLivro) {
        this.generoLivro = generoLivro;
    }
}
