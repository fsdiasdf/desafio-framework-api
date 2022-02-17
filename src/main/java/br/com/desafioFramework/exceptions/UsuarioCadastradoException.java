/**
 *
 */
package br.com.desafioFramework.exceptions;

/**
 * @author Felipe Dias
 *
 */
public class UsuarioCadastradoException extends RuntimeException{

	public UsuarioCadastradoException(String login) {
		super("Usuário já cadastrado para o login " + login);
	}
}
