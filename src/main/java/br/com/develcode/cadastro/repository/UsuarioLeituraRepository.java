package br.com.develcode.cadastro.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.develcode.cadastro.domain.UsuarioDto;

@Repository
public interface UsuarioLeituraRepository {

	public List<UsuarioDto> listar();

	public UsuarioDto buscar(Long id);

}
