/**
 *
 */
package br.com.desafioFramework.dto;

/**
 * @author Felipe Dias
 *
 */
public class LinkDTO {
	private Integer post_id;
	private String descricao;

	/**
	 * @return the post_id
	 */
	public Integer getPost_id() {
		return post_id;
	}
	/**
	 * @param post_id the post_id to set
	 */
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
