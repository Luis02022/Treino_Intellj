package com.example.treinoSenai02.treino02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetshopRepository extends JpaRepository<PetshopRepository, Long> {

}
