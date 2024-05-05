package com.dessa.aulas.repository;

import com.dessa.aulas.model.Aula;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AulaRepository extends CrudRepository<Aula, Long> {
    ArrayList<Aula> findAll();
}
