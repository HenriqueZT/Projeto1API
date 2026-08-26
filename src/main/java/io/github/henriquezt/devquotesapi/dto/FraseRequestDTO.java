package io.github.henriquezt.devquotesapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class FraseRequestDTO {

    @NotBlank(message = "A frase não pode estar vazia")
    @Size(min = 3, max = 255, message = "A frase dever ter entre 3 e 255 caracteres")
    private String frase;
}
