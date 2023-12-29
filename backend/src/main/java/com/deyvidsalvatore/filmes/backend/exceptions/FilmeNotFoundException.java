package com.deyvidsalvatore.filmes.backend.exceptions;

public class FilmeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FilmeNotFoundException() {
        super("O filme não foi encontrado");
    }

}
