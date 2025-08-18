package com.example.treino03.treinamento03.controller;

import com.example.treino03.treinamento03.model.Livro;
import com.example.treino03.treinamento03.model.Usuario;
import com.example.treino03.treinamento03.service.LivroService;
import com.example.treino03.treinamento03.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livro")
public class LivroController {
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/good")
    public String welcome_livro(){
        return "BOA LEITURA!!!";
    }

    @GetMapping("/list_books")
    public List<Livro> listarTodos(){
        return livroService.listarLivros();
    }

    @PostMapping("/save_book")
    public ResponseEntity<Map<String,Object>> salvar (@Valid @RequestBody Livro livro){
        livroService.salvarLivro(livro); // ← aqui é salvarLivro, não atualizarLivro
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Livro cadastrado com sucesso!!"));
    }


    @PutMapping("/update_book")
    public ResponseEntity<String> atualizar(@Valid @RequestBody Livro livro){
        livroService.atualizarLivro(livro);

        return ResponseEntity.status(HttpStatus.CREATED).body("Livro atualizado!");
    }

    @DeleteMapping("/isbn")
    public ResponseEntity<String> deletar(@PathVariable Long isbn){
        livroService.excluir(isbn);

        return ResponseEntity.ok().body("Livro excluido com sucesso");
    }


}
