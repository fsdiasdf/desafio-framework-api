/**
 *
 */
package br.com.desafioFramework.dto;

/**
 * @author Felipe Dias
 *
 */
public class SessaoDTO {
	private String login;
	private String token;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
}
