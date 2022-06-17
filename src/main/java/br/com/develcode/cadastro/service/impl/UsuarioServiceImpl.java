package br.com.develcode.cadastro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.develcode.cadastro.domain.Usuario;
import br.com.develcode.cadastro.mapper.UsuarioMapper;
import br.com.develcode.cadastro.repository.UsuarioEscritaRepository;
import br.com.develcode.cadastro.repository.UsuarioLeituraRepository;
import br.com.develcode.cadastro.service.UsuarioService;

@Component
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioLeituraRepository usuarioLeituraRepo;

	@Autowired
	private UsuarioEscritaRepository usuarioEscritaRepo;

	@Autowired
	private UsuarioMapper mapper;

	@Override
	public List<Usuario> listar() {

		return mapper.mapear(usuarioLeituraRepo.listar());
	}

	@Override
	public Usuario buscar(Long id) {
		return mapper.mapear(usuarioLeituraRepo.buscar(id));
	}

	@Override
	public void salvarOuAtualizar(Usuario usuario) {
		usuarioEscritaRepo.salvarOuAtualizar(usuario);
	}

	@Override
	public void deletar(Long id) {
		usuarioEscritaRepo.deletar(id);
	}

}
