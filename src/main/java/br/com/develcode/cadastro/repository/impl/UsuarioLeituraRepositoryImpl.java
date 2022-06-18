package br.com.develcode.cadastro.repository.impl;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.develcode.cadastro.domain.UsuarioDto;
import br.com.develcode.cadastro.repository.UsuarioLeituraRepository;

@Repository
@PropertySource("classpath:query/usuario_leitura")
public class UsuarioLeituraRepositoryImpl implements UsuarioLeituraRepository {

	@Value("${SQS.USUARIOS.LISTAR}")
	private String queryListar;

	@Value("${SQS.USUARIOS.BUSCAR.ID}")
	private String queryBuscarId;

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(UsuarioLeituraRepositoryImpl.class);

	@Override
	public List<UsuarioDto> listar() {

		List<UsuarioDto> usuarios = jdbcTemplate.query(queryListar,
				BeanPropertyRowMapper.newInstance(UsuarioDto.class));

		return Objects.nonNull(usuarios) ? usuarios : null;
	}

	@Override
	public UsuarioDto buscar(Long id) {
		final MapSqlParameterSource parameter = montarParametro(id);

		return jdbcTemplate.query(queryBuscarId, parameter, BeanPropertyRowMapper.newInstance(UsuarioDto.class))
				.stream().findFirst().orElse(null);
	}

	public MapSqlParameterSource montarParametro(Long id) {
		final MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		return parameter;
	}

}
