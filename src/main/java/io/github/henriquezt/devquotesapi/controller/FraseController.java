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
    public List<FraseResponseDTO> buscarPorFrase(@RequestParam String frase)
    {
        List<Frase> fraseBuscada = fraseService.buscarPorFrase(frase);

        return fraseBuscada.stream().map(
                fraseEncontrada -> new FraseResponseDTO(fraseEncontrada.getId(), fraseEncontrada.getFrase())).toList();
    }

    @GetMapping("/frases/buscar-contendo")
    public List<FraseResponseDTO> buscarPorFraseContida(@RequestParam String palavra) {
        List<Frase> fraseContida = fraseService.buscarPorFraseContida(palavra);

        return fraseContida.stream().map(
                frase -> new FraseResponseDTO(frase.getId(), frase.getFrase())).toList();
    }

    @GetMapping("/frases")
    public List<FraseResponseDTO> listarFrases() {
        List<Frase> frases = fraseService.listarFrases();

        return frases.stream().map(
                frase -> new FraseResponseDTO(frase.getId(), frase.getFrase())).toList();
    }

    @GetMapping("/frases/paginadas")
    public Page<FraseResponseDTO> listarFrasesPaginadas(@RequestParam int pagina, @RequestParam int tamanho) {
        Page<Frase> frasePaginada = fraseService.listarFrasesPaginadas(pagina, tamanho);

        return frasePaginada.map(frase -> new FraseResponseDTO(frase.getId(), frase.getFrase()));
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
    public FraseResponseDTO atualizarPorId(@PathVariable int id, @RequestBody FraseRequestDTO dto) {
        Frase frase = new Frase();
        frase.setFrase(dto.getFrase());

        Frase fraseAtualizada = fraseService.atualizarPorId(id, frase);

        FraseResponseDTO resposta = new FraseResponseDTO();
        resposta.setId(fraseAtualizada.getId());
        resposta.setFrase(fraseAtualizada.getFrase());
        return resposta;
    }

    @DeleteMapping("/frases/{id}")
    public void deletarPorId(@PathVariable int id) {
        fraseService.deletarPorId(id);
    }

}
