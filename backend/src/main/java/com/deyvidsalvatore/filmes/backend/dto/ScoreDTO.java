package com.deyvidsalvatore.filmes.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ScoreDTO {
	
	@NotNull(message = "filmeId não pode ser nulo")
	@Positive(message = "filmeId deve ser um número positivo")
	private Long filmeId;
	
	@NotNull(message = "email não pode ser nulo")
	@NotBlank(message = "email não pode ser branco")
	@Email(message = "email está no formato inválido, usar: exemplo@email.com")
	private String email;
	
	@NotNull(message = "score não pode ser nulo")
	@Positive(message = "score deve ser um número positivo")
	private Double score;
	
	public ScoreDTO() {}

	public Long getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(Long filmeId) {
		this.filmeId = filmeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}
