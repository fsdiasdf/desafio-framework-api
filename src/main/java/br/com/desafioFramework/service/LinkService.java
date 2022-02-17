///**
// *
// */
//package br.com.desafioFramework.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import br.com.desafioFramework.dto.LinkDTO;
//import br.com.desafioFramework.entity.Link;
//import br.com.desafioFramework.entity.Post;
//import br.com.desafioFramework.repository.LinkRepository;
//import br.com.desafioFramework.repository.PostRepository;
//
///**
// * @author Felipe Dias
// *
// */
//@Service
//public class LinkService {
//
//	@Autowired
//	private LinkRepository repository;
//	@Autowired
//	private PostRepository postRepository;
//	
//	public ResponseEntity<Link> incluirLink(LinkDTO linkDTO) {
//		try {
//			Link link = new Link();
//			Post post = postRepository.buscarPorId(linkDTO.getPost_id());
//			if(post != null) {
//				link.setPost(post);
//				link.setDescricao(linkDTO.getDescricao());
//				Link _link = repository.save(link);
//				return new ResponseEntity<>(_link, HttpStatus.CREATED);
//			} else {
//				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//			}
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	public ResponseEntity<HttpStatus> deletarLink(Integer id) {
//		try {
//			repository.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//}
