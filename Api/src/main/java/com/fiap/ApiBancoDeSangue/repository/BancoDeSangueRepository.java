package com.fiap.ApiBancoDeSangue.repository;

import com.fiap.ApiBancoDeSangue.entity.BancoDeSangue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BancoDeSangueRepository extends JpaRepository<BancoDeSangue,Long> {

    Optional<BancoDeSangue> findByIdAndAtivoIsTrue(Long id);

    @Query("from BancoDeSangue a where a.nome like %:nome% and a.ativo = true")
    List<BancoDeSangue> buscaPorNome(String nome);
}