package io.github.henriquezt.devquotesapi.exception;


import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorValidationResponse> tratarErroDeValidacao(
            MethodArgumentNotValidException exception) {

        String campo = exception
                .getBindingResult()
                .getFieldErrors()
                .getFirst()
                .getField();

        String mensagem = exception
                .getBindingResult()
                .getFieldErrors()
                .getFirst()
                .getDefaultMessage();

        ErrorValidationResponse erro = new ErrorValidationResponse(campo, mensagem);

        return ResponseEntity.badRequest().body(erro);
    }
}
