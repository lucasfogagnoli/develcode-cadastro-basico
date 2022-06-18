package br.com.develcode.cadastro.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.develcode.cadastro.domain.UsuarioDto;

@Repository
public interface UsuarioLeituraRepository {

	/**
	 * 
	 * @return uma lista de usuarios
	 */
	public List<UsuarioDto> listar();

	/**
	 * 
	 * @param id do usuario buscado
	 * @return o usuario buscado
	 */
	public UsuarioDto buscar(Long id);

}
