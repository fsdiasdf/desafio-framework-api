/**
 *
 */
package br.com.desafioFramework.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author Felipe Dias
 *
 */
@RestController
public class LoginController {
	/*
	 * @Autowired private PasswordEncoder encoder;
	 * 
	 * @Autowired private UsuarioRepository repository;
	 */

	/*
	 * @PostMapping("/api/login") public SessaoDTO logar(@RequestBody LoginDTO
	 * login){ Optional<Usuario> usuario =
	 * repository.buscarPorUsuario(login.getUsuario()); if(usuario!=null) { boolean
	 * passwordOk = encoder.matches(login.getSenha(), usuario.getSenha()); if
	 * (!passwordOk) { throw new RuntimeException("Senha inválida para o login: " +
	 * login.getUsuario()); } //Enviando um objeto Sessão para retornar mais
	 * informações do usuário SessaoDTO sessao = new SessaoDTO();
	 * sessao.setLogin(usuario.getUsuario() :);
	 * 
	 * JWTObject jwtObject = new JWTObject(); jwtObject.setIssuedAt(new
	 * Date(System.currentTimeMillis())); jwtObject.setExpiration((new
	 * Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
	 * jwtObject.setRoles(usuario.getRoles());
	 * sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY,
	 * jwtObject)); return sessao; }else { throw new
	 * RuntimeException("Erro ao tentar fazer login"); } }
	 */

}
