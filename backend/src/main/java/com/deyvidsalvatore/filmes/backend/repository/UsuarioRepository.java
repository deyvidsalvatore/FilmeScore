package com.deyvidsalvatore.filmes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deyvidsalvatore.filmes.backend.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);
}
