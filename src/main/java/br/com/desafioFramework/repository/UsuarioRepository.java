package br.com.desafioFramework.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.desafioFramework.entity.Usuario;

/**
 * @author Felipe Dias
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("SELECT u FROM Usuario u JOIN FETCH u.roles WHERE u.username = (:usuario)")
	Optional<Usuario> buscarPorUsuario(@Param("usuario") String usuario);
	
	@Query("SELECT u FROM Usuario u WHERE u.id = (:id)")
	public Usuario buscarPorId(Integer id);

	boolean existsByUsername(String usuario);
	
	
//	boolean validarUsuarioCadastrado(String usuario);
}
