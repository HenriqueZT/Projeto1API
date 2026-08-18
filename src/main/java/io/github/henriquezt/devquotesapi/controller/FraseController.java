package io.github.henriquezt.devquotesapi.controller;

import io.github.henriquezt.devquotesapi.model.Frase;
import io.github.henriquezt.devquotesapi.service.FraseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FraseController {

    private final FraseService fraseService;

    public FraseController(FraseService fraseService) {
        this.fraseService = fraseService;
    }

    @GetMapping("/frases")
    public List<Frase> listarFrases() {
        return fraseService.listarFrases();
    }

    @GetMapping("/frases/{id}")
    public Frase buscarPorId(@PathVariable int id) {
        return fraseService.buscarPorId(id);
    }

    @PostMapping("/frases")
    public void criarFrase(@RequestBody Frase frase) {
        fraseService.criarFrase(frase);
    }

    @PutMapping("/frases/{id}")
    public Frase atualizarPorId(@PathVariable int id, @RequestBody Frase frase) {
        return fraseService.atualizarPorId(id, frase);
    }

    @DeleteMapping("/frases/{id}")
    public void deletarPorId(@PathVariable int id) {
        fraseService.deletarPorId(id);
    }

}
