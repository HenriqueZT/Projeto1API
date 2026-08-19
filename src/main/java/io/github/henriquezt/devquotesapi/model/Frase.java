package io.github.henriquezt.devquotesapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Frase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String frase;

    public Frase() {
    }

    public Frase(Integer id, String frase) {
        this.id = id;
        this.frase = frase;
    }

    public Integer getId() {
        return id;
    }

    public String getFrase() {
        return frase;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

}
