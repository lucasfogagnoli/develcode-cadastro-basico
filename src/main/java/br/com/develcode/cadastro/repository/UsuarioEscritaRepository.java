package br.com.develcode.cadastro.repository;

import org.springframework.stereotype.Repository;

import br.com.develcode.cadastro.domain.Usuario;

@Repository
public interface UsuarioEscritaRepository {

	public void salvarOuAtualizar(Usuario usuario);

	public void deletar(Long id);

}
