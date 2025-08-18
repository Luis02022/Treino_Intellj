package com.example.treino03.treinamento03.service;

import com.example.treino03.treinamento03.model.Usuario;
import com.example.treino03.treinamento03.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@Validated
@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(@Valid Usuario usuario){
        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new IllegalArgumentException("Usuario ja cadastrado");
        }else{
            return (Usuario)this.usuarioRepository.save(usuario);
        }

    }

    public Usuario atualizarUsuario(@Valid Usuario usuario){
        Usuario usuarioAtualizar = usuarioRepository.findById(usuario.getId()).orElseThrow(() -> new RuntimeException(("Usuario não encontrado")));

        usuarioAtualizar.setNome(usuario.getNome());
        usuarioAtualizar.setEmail(usuario.getEmail());
        usuarioAtualizar.setTelefone(usuario.getTelefone());
        usuarioAtualizar.setEndereco(usuario.getEndereco());

        return usuarioRepository.save(usuarioAtualizar);

    }

    public void excluirUsuario(Long id){
        Usuario usuario = (Usuario)this.usuarioRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Usuário não encontrado"));

        this.usuarioRepository.deleteById(id);
    }

}
