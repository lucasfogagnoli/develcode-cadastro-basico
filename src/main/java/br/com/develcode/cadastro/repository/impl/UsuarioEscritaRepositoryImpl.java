package br.com.develcode.cadastro.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.develcode.cadastro.domain.Usuario;
import br.com.develcode.cadastro.repository.UsuarioEscritaRepository;

@Component
@PropertySource("classpath:query/usuario_escrita")
public class UsuarioEscritaRepositoryImpl implements UsuarioEscritaRepository {

	@Value("${SQI.USUARIO}")
	private String inserirUsuario;

	@Value("${SQU.USUARIO}")
	private String atualizarUsuario;

	@Value("${SQD.USUARIO}")
	private String deletarUsuario;

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void salvarOuAtualizar(Usuario usuario) {
		String query = inserirUsuario;
		final MapSqlParameterSource parameter = montarParametro(usuario);

		if (usuario.getId() != null) {
			query = atualizarUsuario;
			System.out.println(jdbcTemplate.update(query, parameter));
		} else {
			System.out.println(jdbcTemplate.update(query, parameter));
		}
	}

	public MapSqlParameterSource montarParametro(Usuario usuario) {
		final MapSqlParameterSource parameter = new MapSqlParameterSource();
		if (usuario.getId() != null) {
			parameter.addValue("id", usuario.getId());
		}
		parameter.addValue("nome", usuario.getNome());
		parameter.addValue("dt_nascimento", usuario.getDt_nascimento());
		parameter.addValue("foto", usuario.getFoto());

		return parameter;
	}

	@Override
	public void deletar(Long id) {
		final MapSqlParameterSource parameter = montarParametro(id);

		System.out.println(jdbcTemplate.update(deletarUsuario, parameter));

	}

	public MapSqlParameterSource montarParametro(Long id) {
		final MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		return parameter;
	}

}
