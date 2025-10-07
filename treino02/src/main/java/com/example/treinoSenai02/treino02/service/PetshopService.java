package com.example.treinoSenai02.treino02.service;

import com.example.treinoSenai02.treino02.model.Petshop;
import com.example.treinoSenai02.treino02.repository.PetshopRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class PetshopService {

    private PetshopRepository petshopRepository;

    public PetshopService(PetshopRepository petshopRepository) {
        this.petshopRepository = petshopRepository;
    }

    public List<Petshop> listarTodos(){

        return petshopRepository.findAll();
    }

    public Petshop salvarPetshop(@Valid Petshop petshop){
        if (petshopRepository.findById(petshop.getId()).isPresent()){
            throw new IllegalArgumentException("PetShop já cadastrado");
        }
            return petshopRepository.save(petshop);


    }

    public Petshop atualizarPetshop(@Valid Petshop petshop){
        Petshop  petshopatulizar = petshopRepository.findById(petshop.getId()).orElseThrow(() -> new RuntimeException(("Petshop não cadastrado")));



        petshopatulizar.setNome(petshop.getNome());
        petshopatulizar.setEmail(petshop.getEmail());
        petshopatulizar.setHorario_funcionamento(petshop.getHorario_funcionamento());
        petshopatulizar.setTelefone(petshop.getTelefone());
        petshopatulizar.setEndereco(petshop.getEndereco());

        return petshopRepository.save(petshopatulizar);
    }

    public void excluir(Long id){
        Petshop petshop = petshopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("PetShop não encontrado"));

        petshopRepository.delete(petshop);
    }
}
