package br.com.develcode.cadastro.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.develcode.cadastro.domain.Usuario;
import br.com.develcode.cadastro.domain.UsuarioDto;
import br.com.develcode.cadastro.utils.EncoderDecoder;

@Component
public class UsuarioMapper {

	@Autowired
	private EncoderDecoder encoderDecoder;

	public List<Usuario> mapear(List<UsuarioDto> lstUsuarioDto) {
		List<Usuario> lstUsuario = new ArrayList<>();
		lstUsuarioDto.stream().forEach(usuarioDto -> {
			try {
				Usuario usuario = new Usuario();
				usuario.setId(usuarioDto.getUsu_id());
				usuario.setNome(usuarioDto.getUsu_nome());
				usuario.setDt_nascimento(usuarioDto.getUsu_dt_nascimento());
				if (Objects.nonNull(usuarioDto.getUsu_img_blob()))
					usuario.setFoto(encoderDecoder.decoder(usuarioDto.getUsu_img_blob()));

				lstUsuario.add(usuario);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		return lstUsuario;
	}

	public Usuario mapear(UsuarioDto usuarioDto) throws IOException {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDto.getUsu_id());
		usuario.setNome(usuarioDto.getUsu_nome());
		usuario.setDt_nascimento(usuarioDto.getUsu_dt_nascimento());
		if (Objects.nonNull(usuarioDto.getUsu_img_blob()))
			usuario.setFoto(encoderDecoder.decoder(usuarioDto.getUsu_img_blob()));

		return usuario;
	}
}
