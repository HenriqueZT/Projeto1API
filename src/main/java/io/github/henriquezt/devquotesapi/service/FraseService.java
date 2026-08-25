package io.github.henriquezt.devquotesapi.service;

import io.github.henriquezt.devquotesapi.model.Frase;
import io.github.henriquezt.devquotesapi.repository.FraseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FraseService {

    private FraseRepository fraseRepository;

    public FraseService(FraseRepository fraseRepository) {
        this.fraseRepository = fraseRepository;
    }

    public List<Frase> buscarPorFrase(String frase) {
        return fraseRepository.findByFrase(frase);
    }

    public List<Frase> buscarPorFraseContida(String palavra) {
        return fraseRepository.findByFraseContainingIgnoreCase(palavra);
    }

    public List<Frase> listarFrases() {
        return fraseRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Page<Frase> listarFrasesPaginadas(int pagina, int tamanho) {
        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.by(Sort.Direction.DESC, "id"));
        return fraseRepository.findAll(pageable);
    }

    public Optional<Frase> buscarPorId (Integer id) {
        return fraseRepository.findById(id);
    }

    public Frase salvar(Frase entity) {
        return fraseRepository.save(entity);
    }

    public Frase atualizarPorId(Integer id, Frase frase) {
        Optional<Frase> fraseEncontrada = fraseRepository.findById(id);

        if(fraseEncontrada.isPresent()) {
            Frase fraseAtual = fraseEncontrada.get();
            fraseAtual.setFrase(frase.getFrase());

            return fraseRepository.save(fraseAtual);
        }

        return null;
    }

    public void deletarPorId(Integer id) {
        fraseRepository.deleteById(id);
    }
}
