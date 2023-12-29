package com.deyvidsalvatore.filmes.backend.services;

import org.springframework.stereotype.Service;

import com.deyvidsalvatore.filmes.backend.domain.Filme;
import com.deyvidsalvatore.filmes.backend.domain.Score;
import com.deyvidsalvatore.filmes.backend.domain.Usuario;
import com.deyvidsalvatore.filmes.backend.dto.ScoreDTO;
import com.deyvidsalvatore.filmes.backend.exceptions.FilmeNotFoundException;
import com.deyvidsalvatore.filmes.backend.repository.FilmeRepository;
import com.deyvidsalvatore.filmes.backend.repository.ScoreRepository;
import com.deyvidsalvatore.filmes.backend.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class ScoreService {
	
	private final FilmeRepository filmeRepository;
	
	private final UsuarioRepository usuarioRepository;
	
	private final ScoreRepository scoreRepository;

	public ScoreService(FilmeRepository filmeRepository, UsuarioRepository usuarioRepository,
			ScoreRepository scoreRepository) {
		this.filmeRepository = filmeRepository;
		this.usuarioRepository = usuarioRepository;
		this.scoreRepository = scoreRepository;
	}
	
	@Transactional
	public String saveScore(ScoreDTO scoreDTO) {
	    Usuario usuario = getOrCreateUsuario(scoreDTO.getEmail());

	    Filme filme = filmeRepository.findById(scoreDTO.getFilmeId())
	            .orElseThrow(FilmeNotFoundException::new);

	    Score score = createScore(filme, usuario, scoreDTO.getScore());
	    scoreRepository.save(score);

	    updateFilmeScoreAndCounter(filme);

	    return "Sua avaliação foi salva e o score foi atualizado!";
	}

	private Usuario getOrCreateUsuario(String email) {
	    Usuario usuario = usuarioRepository.findByEmail(email);

	    if (usuario == null) {
	        usuario = createUsuario(email);
	    }

	    return usuario;
	}

	/**
	 * Se não tiver um usuário que foi achado pelo email, irá criar um novo
	 * */
	private Usuario createUsuario(String email) {
	    Usuario usuario = new Usuario();
	    usuario.setEmail(email);
	    return usuarioRepository.saveAndFlush(usuario);
	}

	private Score createScore(Filme filme, Usuario usuario, double scoreValue) {
	    Score score = new Score();
	    score.setFilme(filme);
	    score.setUsuario(usuario);
	    score.setValor(scoreValue);
	    return score;
	}

	private void updateFilmeScoreAndCounter(Filme filme) {
	    double sum = filme.getScores().stream().mapToDouble(Score::getValor).sum();
	    double avg = sum / filme.getScores().size();

	    filme.setScore(avg);
	    filme.setContador(filme.getScores().size());

	    filmeRepository.save(filme);
	}

}
