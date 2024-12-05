package com.example.primeiraapi.repository;

import com.example.primeiraapi.model.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
}
