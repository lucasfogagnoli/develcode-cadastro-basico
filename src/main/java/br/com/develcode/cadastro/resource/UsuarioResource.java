package br.com.develcode.cadastro.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.develcode.cadastro.domain.Usuario;
import br.com.develcode.cadastro.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> usuarios = usuarioService.listar();

		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.buscar(id);

		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		usuarioService.salvarOuAtualizar(usuario);

		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	@PutMapping(path = "/atualizar")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
		usuarioService.salvarOuAtualizar(usuario);

		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	@DeleteMapping(path = "/deletar/{id}")
	public ResponseEntity<Long> deletar(@PathVariable("id") Long id) {
		usuarioService.deletar(id);

		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
}
