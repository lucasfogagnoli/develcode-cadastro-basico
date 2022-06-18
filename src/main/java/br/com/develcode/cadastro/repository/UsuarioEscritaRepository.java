package br.com.develcode.cadastro.repository;

import br.com.develcode.cadastro.domain.Usuario;

public interface UsuarioEscritaRepository {

	/**
	 * 
	 * @param usuario a ser criado ou deletado
	 * @return usuario criado ou atualizado
	 */
	public Usuario salvarOuAtualizar(Usuario usuario);

	/**
	 * 
	 * @param id do usuario a ser deletado
	 */
	public void deletar(Long id);

}
