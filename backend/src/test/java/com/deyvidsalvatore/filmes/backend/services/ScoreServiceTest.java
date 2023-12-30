package com.deyvidsalvatore.filmes.backend.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.deyvidsalvatore.filmes.backend.domain.Filme;
import com.deyvidsalvatore.filmes.backend.domain.Usuario;
import com.deyvidsalvatore.filmes.backend.dto.ScoreDTO;
import com.deyvidsalvatore.filmes.backend.repository.FilmeRepository;
import com.deyvidsalvatore.filmes.backend.repository.ScoreRepository;
import com.deyvidsalvatore.filmes.backend.repository.UsuarioRepository;

class ScoreServiceTest {

	@Test
    void testSaveScore() {
        // Arrange
        FilmeRepository filmeRepository = mock(FilmeRepository.class);
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        ScoreRepository scoreRepository = mock(ScoreRepository.class);

        ScoreService scoreService = new ScoreService(filmeRepository, usuarioRepository, scoreRepository);

        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setEmail("test@example.com");
        scoreDTO.setFilmeId(1L);
        scoreDTO.setScore(4.5);

        Usuario usuario = new Usuario();
        usuario.setEmail("test@example.com");

        Filme filme = new Filme();
        filme.setId(1L);

        when(usuarioRepository.findByEmail("test@example.com")).thenReturn(usuario);
        when(filmeRepository.findById(1L)).thenReturn(Optional.of(filme));

        // Act
        String result = scoreService.saveScore(scoreDTO);

        // Assert
        assertEquals("Sua avaliação foi salva e o score foi atualizado!", result);
    }

}
