package br.com.develcode.cadastro.repository.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.develcode.cadastro.domain.Usuario;
import br.com.develcode.cadastro.repository.UsuarioEscritaRepository;

@Repository
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
	public Usuario salvarOuAtualizar(Usuario usuario) {
		BeanPropertySqlParameterSource parameter = new BeanPropertySqlParameterSource(usuario);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		if (Objects.nonNull(usuario)) {
			String query = inserirUsuario;

			if (Objects.nonNull(usuario.getId()))
				query = atualizarUsuario;

			jdbcTemplate.update(query, parameter, keyHolder);
			Long id = recuperarId(keyHolder);

			if (Objects.nonNull(id))
				usuario.setId(id);

			return usuario;
		}
		return null;
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

	private Long recuperarId(KeyHolder keyHolder) {
		return Objects.nonNull(keyHolder.getKey()) ? keyHolder.getKey().longValue() : null;
	}

}
