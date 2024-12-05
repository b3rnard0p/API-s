package com.example.primeiraapi.controller;

import com.example.primeiraapi.model.Aluno;
import com.example.primeiraapi.repository.AlunoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlunoController {

    private AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
        alunoRepository.saveAll(List.of(
                new Aluno ("Marcelo", "123456789", "marcelo@infnet"),
                new Aluno ("Joao", "123456789", "joao@infnet"),
                new Aluno ("Matheus", "123456789", "matheus@infnet"),
                new Aluno ("Pedro", "123456789", "pedro@infnet"),
                new Aluno ("Bernardo", "123456789", "bernardo@infnet")
        ));
    }

    @GetMapping("/alunos")
    Iterable<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/alunos/{id}")
    Optional<Aluno> getAlunos(@PathVariable int id) {
        return alunoRepository.findById(id);
    }

    @DeleteMapping ("/alunos/{id}")
        ResponseEntity<Aluno> deleteAluno (@PathVariable int id){
            if(alunoRepository.existsById(id)){
                alunoRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/Alunos")
        ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno){
            alunoRepository.save(aluno);
            return ResponseEntity.ok().build();
    }

