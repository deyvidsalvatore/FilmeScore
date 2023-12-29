package com.deyvidsalvatore.filmes.backend.dto;

public class ScoreDTO {
	
	private Long filmeId;
	private String email;
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
