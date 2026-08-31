package io.github.henriquezt.devquotesapi.controller;

import io.github.henriquezt.devquotesapi.dto.FraseRequestDTO;
import io.github.henriquezt.devquotesapi.dto.FraseResponseDTO;
import io.github.henriquezt.devquotesapi.model.Frase;
import io.github.henriquezt.devquotesapi.service.FraseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Frases",
        description = "Operação para gerenciamento e consulta de frases")
@RestController
public class FraseController {

    private final FraseService fraseService;

    public FraseController(FraseService fraseService) {
        this.fraseService = fraseService;
    }

    @Operation(summary = "Busca uma frase pelo texto exato")
    @GetMapping("/frases/buscar")
    public List<FraseResponseDTO> buscarPorFrase(@RequestParam String frase) {
        List<Frase> fraseBuscada = fraseService.buscarPorFrase(frase);

        return fraseBuscada.stream().map(
                this::converterParaResponseDTO).toList();
    }

    @Operation(summary = "Busca frases contendo uma palavra")
    @GetMapping("/frases/buscar-contendo")
    public List<FraseResponseDTO> buscarPorFraseContida(@RequestParam String palavra) {
        List<Frase> fraseContida = fraseService.buscarPorFraseContida(palavra);

        return fraseContida.stream().map(
                this::converterParaResponseDTO).toList();
    }

    @Operation(summary = "Lista todas as frases")
    @GetMapping("/frases")
    public List<FraseResponseDTO> listarFrases() {
        List<Frase> frases = fraseService.listarFrases();

        return frases.stream().map(
                this::converterParaResponseDTO).toList();
    }

    @Operation(summary = "Lista as frases por página")
    @GetMapping("/frases/paginadas")
    public Page<FraseResponseDTO> listarFrasesPaginadas(@RequestParam int pagina, @RequestParam int tamanho) {
        Page<Frase> frasePaginada = fraseService.listarFrasesPaginadas(pagina, tamanho);

        return frasePaginada.map(this::converterParaResponseDTO);
    }

    @Operation(summary = "Busca uma frase pelo ID")
    @GetMapping("/frases/{id}")
    public FraseResponseDTO buscarPorId(@PathVariable int id) {
        Frase fraseSalva = fraseService.buscarPorId(id);

        return converterParaResponseDTO(fraseSalva);
    }

    @Operation(summary = "Cria uma frase")
    @PostMapping("/frases")
    public FraseResponseDTO criarFrase(@Valid @RequestBody FraseRequestDTO dto) {
        Frase frase = converterParaEntity(dto);
        Frase fraseSalva = fraseService.salvar(frase);

        return converterParaResponseDTO(fraseSalva);
    }

    @Operation(summary = "Atualiza uma frase por ID")
    @PutMapping("/frases/{id}")
    public FraseResponseDTO atualizarPorId(@PathVariable int id, @Valid @RequestBody FraseRequestDTO dto) {
        Frase frase = converterParaEntity(dto);
        Frase fraseAtualizada = fraseService.atualizarPorId(id, frase);

        return converterParaResponseDTO(fraseAtualizada);
    }

    @Operation(summary = "Deleta uma frase por ID")
    @DeleteMapping("/frases/{id}")
    public void deletarPorId(@PathVariable int id) {
        fraseService.deletarPorId(id);
    }

    private FraseResponseDTO converterParaResponseDTO(Frase frase) {
        return new FraseResponseDTO(
                frase.getId(),
                frase.getFrase()
        );
    }

    private Frase converterParaEntity(FraseRequestDTO dto) {
        Frase frase = new Frase();
        frase.setFrase(dto.getFrase());

        return frase;
    }
}
