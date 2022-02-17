/**
 *
 */
package br.com.desafioFramework.dto;

import javax.validation.constraints.NotEmpty;

/**
 * @author Felipe Dias
 *
 */
public class AlbumDTO {
	private String usuario;
	@NotEmpty(message = "{campo.album.titulo.obrigatorio}")
	private String titulo;
	private byte[][] imagens; 
	
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
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the imagens
	 */
	public byte[][] getImagens() {
		return imagens;
	}
	/**
	 * @param imagens the imagens to set
	 */
	public void setImagens(byte[][] imagens) {
		this.imagens = imagens;
	}

	
}
