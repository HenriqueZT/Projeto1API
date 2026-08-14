package io.github.henriquezt.devquotesapi.controller;

import io.github.henriquezt.devquotesapi.model.Frase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FraseController {

    private List<Frase> frases = new ArrayList<>();

    public FraseController() {
        Frase frase1 = new Frase(1, "Hora de tomar café");
        Frase frase2 = new Frase(2, "Olá Mundo!");
        Frase frase3 = new Frase(3, "Codar deixa careca");

        frases.add(frase1);
        frases.add(frase2);
        frases.add(frase3);
    }

    @GetMapping("/frases")
    public List<Frase> listarFrases() {
        return frases;
    }
}
