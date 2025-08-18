package com.example.treino03.treinamento03.service;

import com.example.treino03.treinamento03.model.Livro;
import com.example.treino03.treinamento03.model.Usuario;
import com.example.treino03.treinamento03.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class LivroService {
    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarLivros(){
        return livroRepository.findAll();
    }

    public Livro salvarLivro(@Valid Livro livro){
        if(livroRepository.findByTitulo(livro.getTitulo()).isPresent()){
            throw new IllegalArgumentException("Livro ja cadastrado");
        }else{
            return (Livro)this.livroRepository.save(livro);
        }

    }

    public Livro atualizarLivro(@Valid Livro livro){
        Livro livroAtualizar = livroRepository.findById(livro.getIsbn()).orElseThrow(() -> new RuntimeException(("Livro não encontrado")));

    livroAtualizar.setTitulo(livro.getTitulo());
    livroAtualizar.setAutor(livro.getAutor());
    livroAtualizar.setGeneroLivro(livro.getGeneroLivro());
    livroAtualizar.setAnoPublicacao(livro.getAnoPublicacao());

    return livroRepository.save(livroAtualizar);
    }

    public void excluir(Long id){
        Livro livro = (Livro) this.livroRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Livro não encontrado"));


        this.livroRepository.deleteById(id);
    }


}
