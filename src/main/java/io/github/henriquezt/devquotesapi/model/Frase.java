package io.github.henriquezt.devquotesapi.model;

public class Frase {
    private int id;
    private String frase;

    public Frase(int id, String frase) {
        this.id = id;
        this.frase = frase;
    }

    public int getId() {
        return id;
    }

    public String getFrase() {
        return frase;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

}
