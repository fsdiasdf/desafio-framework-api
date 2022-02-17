/**
 *
 */
package br.com.desafioFramework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioFramework.entity.Imagem;

/**
 * @author Felipe Dias
 *
 */
@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Integer>{

	
}
