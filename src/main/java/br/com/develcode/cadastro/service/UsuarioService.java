package br.com.develcode.cadastro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.develcode.cadastro.domain.Usuario;

@Service
public interface UsuarioService {

	public List<Usuario> listar();

	public Usuario buscar(Long id);

	public void salvarOuAtualizar(Usuario usuario);

	public void deletar(Long id);

}
