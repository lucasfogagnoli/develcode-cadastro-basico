package br.com.develcode.cadastro.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.develcode.cadastro.response.Response;

public class Retornos {

	public static <T> ResponseEntity<Response<T>> retornarSucesso(T response) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response<>(response, HttpStatus.OK.value(), "Consulta realizada com sucesso."));
	}

	public static <T> ResponseEntity<Response<T>> retornarSucesso() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response<>(null, HttpStatus.OK.value(), "Deletado com sucesso."));
	}

	public static <T> ResponseEntity<Response<T>> retornarVazioConsulta() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response<>(null, HttpStatus.NO_CONTENT.value(), "Consulta não retornou valores."));
	}

	public static <T> ResponseEntity<Response<T>> retornarVazioCadastro() {
		return ResponseEntity.status(HttpStatus.OK).body(
				new Response<>(null, HttpStatus.NO_CONTENT.value(), "Cadastro/Atualização não retornou valores."));
	}

	public static <T> ResponseEntity<Response<T>> retornarVazioDelecao() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response<>(null, HttpStatus.NO_CONTENT.value(), "Deleção não retornou valores."));
	}

	public static <T> ResponseEntity<Response<T>> retornarCriado(T response) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response<>(response, HttpStatus.CREATED.value(), "Cadastro realizado com sucesso."));
	}

	public static <T> ResponseEntity<Response<T>> retornarAtualizado(T response) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response<>(response, HttpStatus.CREATED.value(), "Atualização realizada com sucesso."));
	}
}
