package com.deyvidsalvatore.filmes.backend.dto;

import com.deyvidsalvatore.filmes.backend.domain.Filme;

public class FilmeDTO {
	private Long id;
	private String titulo;
	private Double score;
	private Integer contador;
	private String imagem;
	
	public FilmeDTO() {}

	public FilmeDTO(Long id, String titulo, Double score, Integer contador, String imagem) {
		this.id = id;
		this.titulo = titulo;
		this.score = score;
		this.contador = contador;
		this.imagem = imagem;
	}

	public FilmeDTO(Filme filme) {
		id = filme.getId();
		titulo = filme.getTitulo();
		score = filme.getScore();
		contador = filme.getContador();
		imagem = filme.getImagem();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
}
