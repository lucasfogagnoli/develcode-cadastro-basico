package br.com.develcode.cadastro.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.com.develcode.cadastro.domain.Usuario;

public interface UsuarioService {

	public List<Usuario> listar();

	public Usuario buscar(Long id) throws IOException;

	public void deletar(Long id);

	public Usuario salvarOuAtualizar(Usuario usuario, MultipartFile file) throws IOException;

}
