package io.github.henriquezt.devquotesapi.controller;

import io.github.henriquezt.devquotesapi.model.Frase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FraseController {


    @GetMapping("/frases")
    public Frase listarFrases() {
        Frase frase = new Frase(1, "Hora de tomar café");

        return frase;
    }
}
