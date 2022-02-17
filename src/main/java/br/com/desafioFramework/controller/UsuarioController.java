/**
 *
 */
package br.com.desafioFramework.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.desafioFramework.entity.Usuario;
import br.com.desafioFramework.exceptions.UsuarioCadastradoException;
import br.com.desafioFramework.service.UsuarioService;

/**
 * @author Felipe Dias
 *
 */
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postUsuario(@RequestBody @Valid Usuario usuario) {
		try {
			service.criarUsuario(usuario);
		}catch (UsuarioCadastradoException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
}
