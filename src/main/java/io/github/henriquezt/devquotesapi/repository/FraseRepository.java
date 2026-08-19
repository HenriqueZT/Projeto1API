package io.github.henriquezt.devquotesapi.repository;

import io.github.henriquezt.devquotesapi.model.Frase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraseRepository extends CrudRepository<Frase, Integer> {

    List<Frase> findByFrase(String frase);
}
