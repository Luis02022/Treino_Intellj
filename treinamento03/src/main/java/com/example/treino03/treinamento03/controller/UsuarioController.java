package com.example.treino03.treinamento03.controller;

import com.example.treino03.treinamento03.model.Usuario;
import com.example.treino03.treinamento03.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Injeção de dependência via construtor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // GET simples de teste
    @GetMapping("/welcome")
    public String welcome() {
        return "Seja Bem-vindo(a)!";
    }


    @GetMapping("/list_users")
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodosUsuarios();
    }


    @PostMapping("/save_users")
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Usuário cadastrado com sucesso!"));
    }

    @PutMapping("/update_users")
    public ResponseEntity<String> atualizar(@Valid @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário atualizado com sucesso!");
    }


    @DeleteMapping("/{id}") // Rota REST correta com o parâmetro na URL
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.ok("Usuário excluído com sucesso!");
    }
}
