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

    //Listar Alunos
    public List<Aluno> listarAlunos(){
        return alunoRepository.findAll();
    }

    //Salvar o Aluno
    public Aluno salvarAluno(@Valid Aluno aluno){
        if(aluno.getCpf() != null && alunoRepository.findByCpf(aluno.getCpf()).isPresent()){
            throw new IllegalArgumentException("Aluno já cadastrado");
        }
        return this.alunoRepository.save(aluno);
    }

    //Atualizar Aluno
    public Aluno atualizarAluno(@Valid Aluno aluno){
        Aluno alunoAtualizar = alunoRepository.findByCpf(aluno.getCpf())
                .orElseThrow(() -> new RuntimeException(("Aluno não cadastrado")));

        alunoAtualizar.setNome(aluno.getNome());
        alunoAtualizar.setDatNascimento(aluno.getDatNascimento());
        alunoAtualizar.setEndereco(aluno.getEndereco());
        alunoAtualizar.setPlano(aluno.getPlano());

        return this.alunoRepository.save(alunoAtualizar);
    }


    //Deletar Aluno
    public void excluirAluno(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Aluno não encontrado"));

        alunoRepository.delete(aluno);
    }

}
