package br.com.develcode.cadastro.resource;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.develcode.cadastro.domain.Usuario;
import br.com.develcode.cadastro.response.Response;
import br.com.develcode.cadastro.service.UsuarioService;
import br.com.develcode.cadastro.utils.Retornos;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<Response<List<Usuario>>> listar() {
		List<Usuario> usuarios = usuarioService.listar();

		return Objects.nonNull(usuarios) ? Retornos.retornarSucesso(usuarios) : Retornos.retornarVazioConsulta();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Usuario>> buscar(@PathVariable("id") Long id) throws IOException {
		Usuario usuario = usuarioService.buscar(id);

		return Objects.nonNull(usuario) ? Retornos.retornarSucesso(usuario) : Retornos.retornarVazioConsulta();
	}

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Response<Usuario>> cadastrar(@RequestPart("usuario") Usuario usuario,
			@RequestPart("file") MultipartFile file) throws IOException {
		System.out.println(file);
		usuarioService.salvarOuAtualizar(usuario, file);

		return Objects.nonNull(usuario) ? Retornos.retornarCriado(usuario) : Retornos.retornarVazioCadastro();
	}

	@PutMapping(path = "/atualizar")
	public ResponseEntity<Response<Usuario>> atualizar(@RequestPart("usuario") Usuario usuario,
			@RequestPart("file") MultipartFile file) throws IOException {
		usuarioService.salvarOuAtualizar(usuario, file);

		return Objects.nonNull(usuario) ? Retornos.retornarAtualizado(usuario) : Retornos.retornarVazioCadastro();
	}

	@DeleteMapping(path = "/deletar/{id}")
	public ResponseEntity<Response<Usuario>> deletar(@PathVariable("id") Long id) {
		usuarioService.deletar(id);

		return Objects.nonNull(id) ? Retornos.retornarSucesso() : Retornos.retornarVazioDelecao();
	}
}
