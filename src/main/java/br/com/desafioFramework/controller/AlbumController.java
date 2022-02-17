/**
 *
 */
package br.com.desafioFramework.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.desafioFramework.dto.AlbumDTO;
import br.com.desafioFramework.entity.Album;
import br.com.desafioFramework.service.AlbumService;

/**
 * @author Felipe Dias
 *
 */
@RestController
@RequestMapping("/api/album")
public class AlbumController {
	@Autowired
	AlbumService service;
	
	@PostMapping
	public ResponseEntity<Album> criarAlbum(@RequestBody @Valid AlbumDTO albumDTO) {
			return service.criarAlbum(albumDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<Album>> recuperarTodosAlbuns(@RequestParam(required = false) String titulo) { 
		return service.recuperarTodosAlbuns(titulo);
	}
	
	@GetMapping("{id}")
	public Album recuperarPorId(@PathVariable("id") Integer id) {
		return service.recuperarPorId(id);
	}
	
	@PutMapping("{id}")
	public Album atualizar(@PathVariable Integer id, @RequestBody @Valid Album albumAtualizado) {
		return service.atualizar(id, albumAtualizado);
	}
	
	@DeleteMapping("{id}")
	public void deletarAlbum(@PathVariable("id") Integer id) {
		service.deletarAlbum(id);
	}
	
	
}
