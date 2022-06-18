package br.com.develcode.cadastro.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.develcode.cadastro.domain.Usuario;
import br.com.develcode.cadastro.domain.UsuarioDto;
import br.com.develcode.cadastro.mapper.UsuarioMapper;
import br.com.develcode.cadastro.repository.UsuarioEscritaRepository;
import br.com.develcode.cadastro.repository.UsuarioLeituraRepository;
import br.com.develcode.cadastro.service.UsuarioService;
import br.com.develcode.cadastro.utils.EncoderDecoder;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioLeituraRepository usuarioLeituraRepo;

	@Autowired
	private UsuarioEscritaRepository usuarioEscritaRepo;

	@Autowired
	private UsuarioMapper mapper;

	@Autowired
	private EncoderDecoder encoderDecoder;

	@Override
	public List<Usuario> listar() {
		List<UsuarioDto> lstUsuarioDto = usuarioLeituraRepo.listar();
		if (!lstUsuarioDto.isEmpty())
			return mapper.mapear(lstUsuarioDto);
		return null;
	}

	@Override
	public Usuario buscar(Long id) throws IOException {
		UsuarioDto usuarioDto = usuarioLeituraRepo.buscar(id);
		if (Objects.nonNull(usuarioDto))
			return mapper.mapear(usuarioDto);
		return null;
	}

	@Override
	public Usuario salvarOuAtualizar(Usuario usuario, MultipartFile file) throws IOException {
		usuario.setFoto(encoderDecoder.encoder(file));

		return usuarioEscritaRepo.salvarOuAtualizar(usuario);
	}

	@Override
	public void deletar(Long id) {
		usuarioEscritaRepo.deletar(id);
	}

}
