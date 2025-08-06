package com.example.treino.treinamento._5.service;

import com.example.treino.treinamento._5.model.Aluno;
import com.example.treino.treinamento._5.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class AlunoService {
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarUsuarios(){
        return alunoRepository.findAll();
    }

    public Aluno salvar(@Valid )

}
