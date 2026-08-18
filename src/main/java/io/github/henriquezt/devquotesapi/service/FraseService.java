package io.github.henriquezt.devquotesapi.service;

import io.github.henriquezt.devquotesapi.model.Frase;
import io.github.henriquezt.devquotesapi.repository.FraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraseService {

    private FraseRepository fraseRepository;

    public FraseService(FraseRepository fraseRepository) {
        this.fraseRepository = fraseRepository;
    }

    public List<Frase> listarFrases() {
        return fraseRepository.listarFrases();
    }

    public Frase buscarPorId( int id) {
        return fraseRepository.buscarPorId(id);
    }

    public void criarFrase(Frase frase) {
        fraseRepository.criarFrase(frase);
    }

    public Frase atualizarPorId(int id, Frase frase) {
        return fraseRepository.atualizarPorId(id, frase);
    }

    public void deletarPorId(int id) {
        fraseRepository.deletarPorId(id);
    }
}
