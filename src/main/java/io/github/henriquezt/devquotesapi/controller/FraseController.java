package io.github.henriquezt.devquotesapi.controller;

import io.github.henriquezt.devquotesapi.model.Frase;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FraseController {

    private List<Frase> frases = new ArrayList<>();

    public FraseController() {
        frases.add(new Frase(1, "Hora de tomar café"));
        frases.add(new Frase(2, "Olá Mundo!"));
        frases.add(new Frase(3, "Codar deixa careca"));
    }

    @GetMapping("/frases")
    public List<Frase> listarFrases() {
        return frases;
    }

    @GetMapping("/frases/{id}")
    public Frase buscarPorId(@PathVariable int id) {
        for(Frase frase : frases) {
            if(frase.getId() == id) {
                return frase;
            }
        }
        return null;
    }

    @PostMapping("/frases")
    public void criarFrase(@RequestBody Frase frase) {
        frases.add(frase);
    }

    @PutMapping("/frases/{id}")
    public Frase atualizarPorId(@PathVariable int id, @RequestBody Frase frase) {
        Frase fraseEncontrada = buscarPorId(id);
        if(fraseEncontrada != null) {
            fraseEncontrada.setFrase(frase.getFrase());
        }
        return fraseEncontrada;
    }

    @DeleteMapping("/frases/{id}")
    public void deletarPorId(@PathVariable int id) {
        Frase fraseEncontrada = buscarPorId(id);

        if(fraseEncontrada != null) {
            frases.remove(fraseEncontrada);
        }
    }
}
