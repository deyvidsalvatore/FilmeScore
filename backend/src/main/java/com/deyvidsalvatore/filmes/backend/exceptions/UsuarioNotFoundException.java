package com.deyvidsalvatore.filmes.backend.exceptions;

public class UsuarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UsuarioNotFoundException() {
        super("O usuário não foi encontrado!");
    }

}
