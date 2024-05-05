package com.dessa.aulas.controller;

import com.dessa.aulas.model.Aula;
import com.dessa.aulas.model.AulaDto;
import com.dessa.aulas.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class RouterController {

    @Autowired
    private AulaRepository aulaRepository;

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        ArrayList<Aula> aulas = this.aulaRepository.findAll();
        // Convertendo Aula para AulaViewDTO
        ArrayList<AulaDto> aulasViewDTO = new ArrayList<>();
        for (Aula a : aulas) {
             aulasViewDTO.add(new AulaDto(a));
        }
        mv.addObject("aulas", aulasViewDTO);
        return mv;
    }

    @GetMapping("/nova")
    public String novaAula() {
        return "nova";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editAula(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("edit");
        Aula aula = new Aula();
        Optional<Aula> opt = this.aulaRepository.findById(id);
        if (opt.isPresent()) {
            aula = opt.get();
        }
        AulaDto aulaViewDTO = new AulaDto(aula);
        aulaViewDTO.reverteFormatoData();
        mv.addObject("aula", aulaViewDTO);
        return mv;
    }

}
