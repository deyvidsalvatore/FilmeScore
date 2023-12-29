package com.deyvidsalvatore.filmes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deyvidsalvatore.filmes.backend.domain.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

}
