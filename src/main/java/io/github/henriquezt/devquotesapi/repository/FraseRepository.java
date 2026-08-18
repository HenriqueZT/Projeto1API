package io.github.henriquezt.devquotesapi.repository;

import io.github.henriquezt.devquotesapi.model.Frase;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FraseRepository {

    private List<Frase> frases = new ArrayList<>();

    public FraseRepository() {
        frases.add(new Frase(1, "Hora de tomar café"));
        frases.add(new Frase(2, "Olá Mundo!"));
        frases.add(new Frase(3, "Codar deixa careca"));
    }

    public List<Frase> listarFrases() {
        return frases;
    }

    public Frase buscarPorId( int id) {
        for(Frase frase : frases) {
            if(frase.getId() == id) {
                return frase;
            }
        }
        return null;
    }

    public void criarFrase(Frase frase) {
        frases.add(frase);
    }

    public Frase atualizarPorId(int id, Frase frase) {
        Frase fraseEncontrada = buscarPorId(id);
        if (fraseEncontrada != null) {
            fraseEncontrada.setFrase(frase.getFrase());
        }
        return fraseEncontrada;
    }

    public void deletarPorId(int id) {
        Frase fraseEncontrada = buscarPorId(id);

        if(fraseEncontrada != null) {
            frases.remove(fraseEncontrada);
        }
    }
}
