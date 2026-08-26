package io.github.henriquezt.devquotesapi.controller;

import io.github.henriquezt.devquotesapi.dto.FraseRequestDTO;
import io.github.henriquezt.devquotesapi.dto.FraseResponseDTO;
import io.github.henriquezt.devquotesapi.model.Frase;
import io.github.henriquezt.devquotesapi.service.FraseService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FraseController {

    private final FraseService fraseService;

    public FraseController(FraseService fraseService) {
        this.fraseService = fraseService;
    }

    @GetMapping("/frases/buscar")
    public List<Frase> buscarPorFrase(@RequestParam String frase) {
        return fraseService.buscarPorFrase(frase);
    }

    @GetMapping("/frases/buscar-contendo")
    public List<Frase> buscarPorFraseContida(@RequestParam String palavra) {
        return fraseService.buscarPorFraseContida(palavra);
    }

    @GetMapping("/frases")
    public List<Frase> listarFrases() {
        return fraseService.listarFrases();
    }

    @GetMapping("/frases/paginadas")
    public Page<Frase> listarFrasesPaginadas(@RequestParam int pagina, @RequestParam int tamanho) {
        return fraseService.listarFrasesPaginadas(pagina, tamanho);
    }

    @GetMapping("/frases/{id}")
    public Optional<FraseResponseDTO> buscarPorId(@PathVariable int id) {
        Optional<Frase> fraseSalva = fraseService.buscarPorId(id);

        return fraseSalva.map(frase -> new FraseResponseDTO(frase.getId(), frase.getFrase()));
    }

    @PostMapping("/frases")
    public FraseResponseDTO criarFrase(@RequestBody FraseRequestDTO dto)
    {
        Frase frase = new Frase();
        frase.setFrase(dto.getFrase());

        Frase fraseSalva = fraseService.salvar(frase);

        FraseResponseDTO resposta = new FraseResponseDTO();
        resposta.setId(fraseSalva.getId());
        resposta.setFrase(fraseSalva.getFrase());

        return resposta;
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
