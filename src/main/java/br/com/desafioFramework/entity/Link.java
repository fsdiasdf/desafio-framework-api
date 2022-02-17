///**
// *
// */
//package br.com.desafioFramework.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import br.com.desafioFramework.util.Constantes;
//
///**
// * @author Felipe Dias
// *
// */
//@Entity
//@Table(name = "tb_link", schema = Constantes.SCHEMA_DESAFIO)
//public class Link {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_link")
//	private Integer id;
//	
//	@ManyToOne
//	@JoinColumn(name = "id_post")
//	private Post post;
//	
//	@Column(name = "ds_link")
//	private String descricao;
//
//	/**
//	 * @return the id
//	 */
//	public Integer getId() {
//		return id;
//	}
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	/**
//	 * @return the post
//	 */
//	public Post getPost() {
//		return post;
//	}
//
//	/**
//	 * @param post the post to set
//	 */
//	public void setPost(Post post) {
//		this.post = post;
//	}
//
//	/**
//	 * @return the descricao
//	 */
//	public String getDescricao() {
//		return descricao;
//	}
//
//	/**
//	 * @param descricao the descricao to set
//	 */
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//	
//}
