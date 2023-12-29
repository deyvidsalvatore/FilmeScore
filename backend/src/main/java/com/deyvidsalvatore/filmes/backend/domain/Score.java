package com.deyvidsalvatore.filmes.backend.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {
	
	@EmbeddedId
	private ScorePK id = new ScorePK();
	
	private Double valor;
	
	public Score() {}

	public void setFilme(Filme filme) {
		id.setFilme(filme);
	}
	
	public void setUsuario(Usuario usuario) {
		id.setUsuario(usuario);
	}
	
	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
