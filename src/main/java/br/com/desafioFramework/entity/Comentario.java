/**
 *
 */
package br.com.desafioFramework.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.desafioFramework.util.Constantes;

/**
 * @author Felipe Dias
 *
 */
@Entity
@Table(name = "tb_comentario", schema = Constantes.SCHEMA_DESAFIO)
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_comentario")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_post")
	@JsonBackReference
	private Post post;
	
	@Column(name = "ds_comentario")
	private String comentario;
	
	@Column(name = "dh_publicacao")
	@JsonFormat(pattern = "dd/MM/yyy")
	private LocalDate publicacao;
	
	@ManyToOne
	@JoinColumn(name = "id_autor_comentario", referencedColumnName = "id_usuario")
	private Usuario usuario;

	@PrePersist
	public void prePersist() {
		setPublicacao(LocalDate.now());
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(Post post) {
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
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the publicacao
	 */
	public LocalDate getPublicacao() {
		return publicacao;
	}

	/**
	 * @param publicacao the publicacao to set
	 */
	public void setPublicacao(LocalDate publicacao) {
		this.publicacao = publicacao;
	}


}
