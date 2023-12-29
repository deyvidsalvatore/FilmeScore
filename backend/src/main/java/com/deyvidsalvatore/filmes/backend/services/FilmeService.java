package com.deyvidsalvatore.filmes.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deyvidsalvatore.filmes.backend.domain.Filme;
import com.deyvidsalvatore.filmes.backend.dto.FilmeDTO;
import com.deyvidsalvatore.filmes.backend.exceptions.FilmeNotFoundException;
import com.deyvidsalvatore.filmes.backend.repository.FilmeRepository;

@Service
public class FilmeService {

	private final FilmeRepository filmeRepository;

	public FilmeService(FilmeRepository filmeRepository) {
		this.filmeRepository = filmeRepository;
	}
	
	@Transactional(readOnly = true)
	public Page<FilmeDTO> findAllFilmesByPage(Pageable pageable) {
		 Page<Filme> filmePage = filmeRepository.findAll(pageable);
		 return filmePage.map(FilmeDTO::new);
	}
	
	@Transactional(readOnly = true)
	public FilmeDTO findFilmeById(Long id) {
		Filme filme = filmeRepository.findById(id).orElseThrow(FilmeNotFoundException::new);
		return new FilmeDTO(filme);
	}
}
