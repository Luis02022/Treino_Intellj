package com.example.treino.treinamento._5.controller;

import com.example.treino.treinamento._5.model.Aluno;
import com.example.treino.treinamento._5.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/aluno")
public class AlunoController {
    private AlunoService alunoService;


    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @GetMapping("")
    public List<Aluno> listar(){
        return alunoService.listarAlunos();
    }


    @PostMapping("")
    public ResponseEntity<>
}
