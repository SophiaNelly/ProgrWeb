package com.dessa.aulas.config;

import com.dessa.aulas.enums.DisciplinaEnum;
import com.dessa.aulas.model.Aula;
import com.dessa.aulas.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public void run(String... args) throws Exception {
        Utils.startDb(this.aulaRepository);
    }
}
