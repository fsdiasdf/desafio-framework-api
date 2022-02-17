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

import br.com.desafioFramework.dto.AlbumDTO;
import br.com.desafioFramework.entity.Album;
import br.com.desafioFramework.entity.Imagem;
import br.com.desafioFramework.entity.Usuario;
import br.com.desafioFramework.repository.AlbumRepository;
import br.com.desafioFramework.repository.UsuarioRepository;

/**
 * @author Felipe Dias
 *
 */
@Service
public class AlbumService {

	@Autowired
	private AlbumRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public ResponseEntity<Album> criarAlbum(AlbumDTO albumDTO) {
		try {
			Album album = new Album();
			List<Imagem> imagens = new ArrayList<Imagem>();
			Usuario usuario = usuarioRepository.buscarPorUsuario(albumDTO.getUsuario())
					.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));;
			if(usuario != null) {
				album.setUsuario(usuario);
				album.setTitulo(albumDTO.getTitulo());
				
				if(albumDTO.getImagens() != null) {
					for (int i = 0; i < albumDTO.getImagens().length; i++) {
					Imagem imagem = new Imagem();
					byte[] imagemArray = albumDTO.getImagens()[i];
					imagem.setImagem(imagemArray);
					imagem.setUsuario(usuario);
					imagens.add(imagem);
					}
					album.setImagens(imagens);
				}
				
				Album _album = repository.save(album);
				return new ResponseEntity<>(_album, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<List<Album>> recuperarTodosAlbuns(String titulo) {
		try {
		List<Album> albuns = new ArrayList<Album>();
		if(titulo == null) {
			repository.findAll().forEach(albuns::add);
		} else {
			repository.recuperarAlbumPorTitulo(titulo).forEach(albuns::add);;
		}
		if(albuns.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(albuns, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public Album recuperarPorId(Integer id) {
		return repository
				.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Álbum não encontrado."));
	}
	
	public Album atualizar(Integer id, Album albumAtualizado) {
		return repository.findById(id)
				.map(album -> {
					album.setTitulo(albumAtualizado.getTitulo());
					
					return repository.save(album);
				})
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Álbum não atualizado."));
				
	}
	
	public void deletarAlbum(Integer id) {
		repository
			.findById(id)
			.map( album -> {
				repository.delete(album);
				return Void.TYPE;
			})
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Álbum não encontrado."));
	}
	
}
