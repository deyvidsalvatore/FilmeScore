package com.deyvidsalvatore.filmes.backend.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.deyvidsalvatore.filmes.backend.domain.Filme;
import com.deyvidsalvatore.filmes.backend.dto.FilmeDTO;
import com.deyvidsalvatore.filmes.backend.exceptions.FilmeNotFoundException;
import com.deyvidsalvatore.filmes.backend.repository.FilmeRepository;

class FilmeServiceTest {

	@Test
	void testFindAllFilmesByPage() {
		// Arrange
		FilmeRepository filmeRepository = mock(FilmeRepository.class);
		FilmeService filmeService = new FilmeService(filmeRepository);
		
		// Mock Data
		Filme filme1 = new Filme(1L, "Capitão América", 4.2, 4, "http://sample.com");
		Filme filme2 = new Filme(2L, "Homem Aranha", 4.5, 4, "http://sample.com");
		Page<Filme> page = new PageImpl<>(List.of(filme1, filme2));
		
		when(filmeRepository.findAll(any(Pageable.class))).thenReturn(page);
		
		// Act
        Page<FilmeDTO> result = filmeService.findAllFilmesByPage(Pageable.unpaged());

        // Assert
        assertEquals(2, result.getTotalElements()); 
	}

	@Test
	public void testFindFilmeById() {
	    // Arrange
	    FilmeRepository filmeRepository = mock(FilmeRepository.class);
	    FilmeService filmeService = new FilmeService(filmeRepository);

	    // Mock Data
	    Filme filme = new Filme(1L, "Capitão América", 4.2, 4, "http://sample.com");
	    when(filmeRepository.findById(anyLong())).thenReturn(Optional.of(filme));

	    // Act
	    FilmeDTO result = filmeService.findFilmeById(1L);

	    // Assert
	    assertNotNull(result);
	    assertEquals(filme.getId(), result.getId());
	}

	
	@Test
    public void testFindFilmeByIdFilmeNotFound() {
        // Arrange
        FilmeRepository filmeRepository = mock(FilmeRepository.class);
        FilmeService filmeService = new FilmeService(filmeRepository);

        when(filmeRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act e Assert
        assertThrows(FilmeNotFoundException.class, () -> filmeService.findFilmeById(1L));
    }

}
