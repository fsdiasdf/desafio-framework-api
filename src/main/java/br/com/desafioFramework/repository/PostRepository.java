/**
 *
 */
package br.com.desafioFramework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.desafioFramework.entity.Post;

/**
 * @author Felipe Dias
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

	@Query("SELECT p FROM Post p WHERE p.titulo = (:titulo)")
	public List<Post> recuperarPostPorTitulo(String titulo);
	
	@Query("SELECT p FROM Post p WHERE p.id = (:id)")
	public Post buscarPorId(Integer id);
}
