/**
 *
 */
package br.com.desafioFramework.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.desafioFramework.entity.Usuario;
import br.com.desafioFramework.exceptions.UsuarioCadastradoException;
import br.com.desafioFramework.repository.UsuarioRepository;

/**
 * @author Felipe Dias
 *
 */
@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.buscarPorUsuario(username)
				.orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));
		
		String[] roles = usuario.getRoles().stream()
											.toArray(String[]::new);
		
		return User
				.builder()
				.username(usuario.getUsername())
				.password(usuario.getPassword())
				.roles(roles).build();
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		List<String> roles = new ArrayList<String>();
		roles.add("USUARIO");
		String senha = usuario.getPassword();
		usuario.setPassword(senha);
		usuario.setRoles(roles);
		boolean exists = repository.existsByUsername(usuario.getUsername());
		if(exists) {
			throw new UsuarioCadastradoException(usuario.getUsername());
		}
		return repository.save(usuario);
	}
	
	
	
}
