package com.dessa.aulas.config;

import com.dessa.aulas.enums.DisciplinaEnum;
import com.dessa.aulas.model.Aula;
import com.dessa.aulas.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Utils {


    public static void startDb(AulaRepository aulaRepository) {
        // Inserindo aulas no banco de dados
        Aula a1 = new Aula();
        a1.setAssunto("Integral indefinida");
        a1.setCodDisciplina(DisciplinaEnum.CALCULO.getCodigo());
        a1.setData("2024-03-25");
        a1.setHorario("14:00");
        a1.setDuracao(3);
        aulaRepository.save(a1);

        Aula a2 = new Aula();
        a2.setAssunto("Relatividade Geral");
        a2.setCodDisciplina(DisciplinaEnum.FISICA.getCodigo());
        a2.setData("2024-03-26");
        a2.setHorario("16:00");
        a2.setDuracao(3);
        aulaRepository.save(a2);

        Aula a3 = new Aula();
        a3.setAssunto("Lógica de Predicados");
        a3.setCodDisciplina(DisciplinaEnum.LOGICA.getCodigo());
        a3.setData("2024-03-28");
        a3.setHorario("17:00");
        a3.setDuracao(3);
        aulaRepository.save(a3);
    }
}
