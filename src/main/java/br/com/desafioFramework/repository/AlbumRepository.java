/**
 *
 */
package br.com.desafioFramework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.desafioFramework.entity.Album;

/**
 * @author Felipe Dias
 *
 */
@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

	@Query("SELECT a FROM Album a WHERE a.titulo = (:titulo)")
	public List<Album> recuperarAlbumPorTitulo(String titulo);
	
}
