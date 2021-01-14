package com.fiap.ApiBancoDeSangue.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fiap.ApiBancoDeSangue.entity.Doador;

public interface DoadorRepository extends JpaRepository<Doador,Long> {

    Optional<Doador> findByIdAndAtivoIsTrue(Long id);

    @Query("from Doador a where a.nome like %:nome% and a.ativo = true")
    List<Doador> buscaPorNome(String nome);
}