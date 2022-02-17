/**
 *
 */
package br.com.desafioFramework.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.desafioFramework.dto.PostDTO;
import br.com.desafioFramework.entity.Post;
import br.com.desafioFramework.service.PostService;

/**
 * @author Felipe Dias
 *
 */
@RestController
@RequestMapping("/api/post")
public class PostController {
	
	@Autowired
	private PostService service; 
	
	@PostMapping
	public ResponseEntity<Post> criarPost(@RequestBody @Valid PostDTO post) {
		return service.criarPost(post);
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> recuperarTodosPosts(@RequestParam(required = false) String titulo) { 
		return service.recuperarTodosPosts(titulo);
	}
	
	@GetMapping("{id}")
	public Post recuperarPorId(@PathVariable("id") Integer id) {
		return service.recuperarPorId(id);
	}
	
	@PutMapping("{id}")
	public Post atualizar(@PathVariable Integer id, @RequestBody @Valid Post postAtualizado) {
		return service.atualizar(id, postAtualizado);
	}
	
	@DeleteMapping("{id}")
	public void deletarPost(@PathVariable("id") Integer id) {
		service.deletarPost(id);
	}
}
