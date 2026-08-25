package io.github.henriquezt.devquotesapi.repository;

import io.github.henriquezt.devquotesapi.model.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraseRepository extends JpaRepository<Frase, Integer> {

    List<Frase> findByFrase(String frase);
    List<Frase> findByFraseContainingIgnoreCase(String palavra);
}
