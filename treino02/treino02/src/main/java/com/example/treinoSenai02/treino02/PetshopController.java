package com.example.treinoSenai02.treino02;

import com.example.treinoSenai02.treino02.model.Petshop;
import com.example.treinoSenai02.treino02.service.PetshopService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/petshop")
public class PetshopController {
    private PetshopService petshopService;

    public PetshopController(PetshopService petshopService) {
        this.petshopService = petshopService;
    }

    @GetMapping("/list")
    public List<Petshop> listarTodos(){
        return petshopService.listarTodos();
    }


    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody Petshop petshop){
        petshopService.salvarPetshop(petshop);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "PetShop cadastrado com sucesso!"));

    }
    
}
