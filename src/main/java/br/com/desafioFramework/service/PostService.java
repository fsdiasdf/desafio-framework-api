/**
 *
 */
package br.com.desafioFramework.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.desafioFramework.dto.PostDTO;
import br.com.desafioFramework.entity.Imagem;
import br.com.desafioFramework.entity.Post;
import br.com.desafioFramework.entity.Usuario;
import br.com.desafioFramework.repository.PostRepository;
import br.com.desafioFramework.repository.UsuarioRepository;

/**
 * @author Felipe Dias
 *
 */
@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public ResponseEntity<Post> criarPost(PostDTO postDTO) {
		try {
			Post post = new Post();
			List<Imagem> imagens = new ArrayList<Imagem>();
			Usuario usuario = usuarioRepository.buscarPorUsuario(postDTO.getUsuario())
					.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));;
			if(usuario != null) {
				post.setUsuario(usuario);
				post.setTitulo(postDTO.getTitulo());
				post.setTexto(postDTO.getTexto());
				post.setLink(postDTO.getLink());
				
				if(postDTO.getImagens() != null) {
					for (int i = 0; i < postDTO.getImagens().length; i++) {
					Imagem imagem = new Imagem();
					byte[] imagemArray = postDTO.getImagens()[i];
					imagem.setImagem(imagemArray);
					imagem.setUsuario(usuario);
					imagens.add(imagem);
					}
					post.setImagens(imagens);
				}
				
				Post _post = repository.save(post);
				return new ResponseEntity<>(_post, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Post>> recuperarTodosPosts(String titulo) {
		try {
		List<Post> posts = new ArrayList<Post>();
		if(titulo == null) {
			repository.findAll().forEach(posts::add);
		} else {
			repository.recuperarPostPorTitulo(titulo).forEach(posts::add);;
		}
		if(posts.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(posts, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public Post recuperarPorId(Integer id) {
		return repository
				.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post não encontrado."));
	}
	
	public Post atualizar(Integer id, Post postAtualizado) {
		return repository.findById(id)
				.map(post -> {
					post.setTitulo(postAtualizado.getTitulo());
					post.setTexto(postAtualizado.getTexto());
					post.setLink(postAtualizado.getLink());
					
					return repository.save(post);
				})
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post não atualizado."));
				
	}
	
	public void deletarPost(Integer id) {
		repository
			.findById(id)
			.map( post -> {
				repository.delete(post);
				return Void.TYPE;
			})
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post não encontrado."));
	}
}
