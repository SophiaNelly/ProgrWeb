package com.dessa.aulas.controller;

import com.dessa.aulas.config.Utils;
import com.dessa.aulas.model.Aula;
import com.dessa.aulas.model.AulaDto;
import com.dessa.aulas.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private AulaRepository aulaRepository;

    @PostMapping("/registrarEdit")
    public ResponseEntity<Object> editAula(@RequestBody AulaDto dto) {
        Optional<Aula> opt = this.aulaRepository.findById(Long.parseLong(dto.id));
        if (!opt.isPresent()) {
            // TODO: fazer algo se a aula não existe!
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mensagem de erro");
        }
        Aula aula = new Aula(dto);
        return ResponseEntity.status(HttpStatus.OK).body(this.aulaRepository.save(aula));
    }

    @PostMapping("/registrarNova")
    public ResponseEntity<Object> novaAula(@RequestBody AulaDto dto) {
        Aula aula = new Aula(dto);
        return ResponseEntity.status(HttpStatus.OK).body(this.aulaRepository.save(aula));
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody String id) {
        Long aulaId = Long.parseLong(id);
        this.aulaRepository.deleteById(aulaId);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping("/reset")
    public ResponseEntity<Object> reset() {
        this.aulaRepository.deleteAll();
        Utils.startDb(this.aulaRepository);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

}
