package com.example.treinoSenai02.treino02.repository;

import com.example.treinoSenai02.treino02.model.Petshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetshopRepository extends JpaRepository<Petshop, Long> {
    Optional<Petshop> findById(Long id);
}
