package com.deyvidsalvatore.filmes.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deyvidsalvatore.filmes.backend.dto.ScoreDTO;
import com.deyvidsalvatore.filmes.backend.services.ScoreService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/score")
public class ScoreController {
	
	private final ScoreService scoreService;
	
	public ScoreController(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	@PutMapping
	public ResponseEntity<String> salvaScore(@Valid @RequestBody ScoreDTO scoreDTO) {
		return ResponseEntity.ok().body(scoreService.saveScore(scoreDTO));
	}

}
