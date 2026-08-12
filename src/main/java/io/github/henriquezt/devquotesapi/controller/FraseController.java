package io.github.henriquezt.devquotesapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraseController {

    @GetMapping("/frases")
    public String listarFrases() {
        return "API funcionando!";
    }
}
