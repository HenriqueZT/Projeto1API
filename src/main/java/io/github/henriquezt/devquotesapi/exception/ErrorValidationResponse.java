package io.github.henriquezt.devquotesapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorValidationResponse {

    private String campo;
    private String mensagem;
}
