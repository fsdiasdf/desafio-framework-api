/**
 *
 */
package br.com.desafioFramework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.desafioFramework.entity.Comentario;

/**
 * @author Felipe Dias
 *
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{

	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Comentario c WHERE c.usuario.id = (:idUsuario) and c.id = (:idComentario)")
	public boolean criadorDoComentario(Integer idUsuario, Integer idComentario);
	
	
	@Query("SELECT c FROM Comentario c WHERE c.id = (:id)")
	public Comentario buscarPorId(Integer id);
}
