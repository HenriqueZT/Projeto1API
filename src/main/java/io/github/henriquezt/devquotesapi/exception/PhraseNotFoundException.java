package io.github.henriquezt.devquotesapi.exception;

public class PhraseNotFoundException extends RuntimeException {

    public PhraseNotFoundException(String mensagem) {
        super(mensagem);
    }
}
