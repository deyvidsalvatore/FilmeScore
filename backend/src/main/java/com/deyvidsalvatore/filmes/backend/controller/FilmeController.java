package com.deyvidsalvatore.filmes.backend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deyvidsalvatore.filmes.backend.dto.FilmeDTO;
import com.deyvidsalvatore.filmes.backend.services.FilmeService;

@RestController
@RequestMapping(value = "api/v1/filmes")
@CrossOrigin("*")
public class FilmeController {
	
	private final FilmeService filmeService;

	public FilmeController(FilmeService filmeService) {
		this.filmeService = filmeService;
	}

	@GetMapping
	public ResponseEntity<Page<FilmeDTO>> findAllFilmesByPage(Pageable pageable) {
		return ResponseEntity.ok().body(filmeService.findAllFilmesByPage(pageable));
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<FilmeDTO> findFilmeById(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(filmeService.findFilmeById(id));
	}

}
