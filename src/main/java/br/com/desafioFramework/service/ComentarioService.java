/**
 *
 */
package br.com.desafioFramework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.desafioFramework.dto.ComentarioDTO;
import br.com.desafioFramework.entity.Comentario;
import br.com.desafioFramework.entity.Post;
import br.com.desafioFramework.entity.Usuario;
import br.com.desafioFramework.repository.ComentarioRepository;
import br.com.desafioFramework.repository.PostRepository;
import br.com.desafioFramework.repository.UsuarioRepository;

/**
 * @author Felipe Dias
 *
 */
@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository repository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public ResponseEntity<Comentario> criarComentario(ComentarioDTO comentarioDTO) {
		try {
			Comentario comentario = new Comentario();
			Post post = postRepository.buscarPorId(comentarioDTO.getPost());
			Usuario usuario = usuarioRepository.buscarPorUsuario(comentarioDTO.getUsuario())
					.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));;
			if(post != null) {
				comentario.setPost(post);
				comentario.setComentario(comentarioDTO.getComentario());
				comentario.setUsuario(usuario);
				Comentario _comentario = repository.save(comentario);
				return new ResponseEntity<>(_comentario, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<HttpStatus> deletarComentario(Integer id) {
		try {
			//TODO: RETORNAR PARA REALIZAR CORRETAMENTE A REGRA REFERENTE A EXCLUSÃO COMENTÁRIO SOMENTE POR AQUELE QUE O CRIOU.
			
			boolean autor;
			Comentario comentario = repository.buscarPorId(id);
			autor = repository.criadorDoComentario(comentario.getUsuario().getId(), comentario.getId());
			if(autor) {
				repository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
