/**
 *
 */
package br.com.desafioFramework.dto;

/**
 * @author Felipe Dias
 *
 */
public class ComentarioDTO {

	private Integer post;
	private String comentario;
	private String usuario;

	
	/**
	 * @return the post
	 */
	public Integer getPost() {
		return post;
	}
	/**
	 * @param post the post to set
	 */
	public void setPost(Integer post) {
		this.post = post;
	}
	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
