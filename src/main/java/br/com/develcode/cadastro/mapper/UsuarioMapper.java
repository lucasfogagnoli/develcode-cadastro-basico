package br.com.develcode.cadastro.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.develcode.cadastro.domain.Usuario;
import br.com.develcode.cadastro.domain.UsuarioDto;

@Component
public class UsuarioMapper {

	public List<Usuario> mapear(List<UsuarioDto> lstUsuarioDto) {
		List<Usuario> lstUsuario = new ArrayList<>();
		lstUsuarioDto.stream().forEach(usuarioDto -> {
			Usuario usuario = new Usuario();
			usuario.setId(usuarioDto.getUsu_id());
			usuario.setNome(usuarioDto.getUsu_nome());
			usuario.setDt_nascimento(usuarioDto.getUsu_dt_nascimento());

			lstUsuario.add(usuario);
		});

		return lstUsuario;
	}

	public Usuario mapear(UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDto.getUsu_id());
		usuario.setNome(usuarioDto.getUsu_nome());
		usuario.setDt_nascimento(usuarioDto.getUsu_dt_nascimento());

		return usuario;
	}
}
