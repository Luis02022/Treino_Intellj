package com.example.treinoSenai02.treino02.service;

import com.example.treinoSenai02.treino02.repository.PetshopRepository;
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

    public List<PetshopRepository> listarTodos(){
    return petshopRepository.findAll();
}


