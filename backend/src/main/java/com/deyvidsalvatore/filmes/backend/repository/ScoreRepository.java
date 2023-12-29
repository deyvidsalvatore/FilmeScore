package com.deyvidsalvatore.filmes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deyvidsalvatore.filmes.backend.domain.Score;
import com.deyvidsalvatore.filmes.backend.domain.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
	
}
