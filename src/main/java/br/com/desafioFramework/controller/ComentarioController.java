/**
 *
 */
package br.com.desafioFramework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.desafioFramework.dto.ComentarioDTO;
import br.com.desafioFramework.entity.Comentario;
import br.com.desafioFramework.service.ComentarioService;

/**
 * @author Felipe Dias
 *
 */
@Controller
@RequestMapping("/api")
public class ComentarioController {

	@Autowired
	private ComentarioService service;
	
	
	@PostMapping("/comentario")
	public ResponseEntity<Comentario> criarComentario(@RequestBody ComentarioDTO comentario) {
		return service.criarComentario(comentario);
	}
	
	@DeleteMapping("/comentario/{id}")
	public ResponseEntity<HttpStatus> deletarComentario(@PathVariable("id") Integer id) {
		return service.deletarComentario(id);
	}
	
}
