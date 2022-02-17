/**
 *
 */
package br.com.desafioFramework.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.desafioFramework.util.Constantes;

/**
 * @author Felipe Dias
 *
 */
@Entity
@Table(name = "tb_post", schema = Constantes.SCHEMA_DESAFIO)
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_post", nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@Column(name = "ds_titulo", nullable = false)
	private String titulo;
	
	@Column(name = "tx_post", nullable = true)
	private String texto;

	@Column(name = "ds_link")
	private String link;
	
	@Column(name = "dh_publicacao", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate publicacao;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comentario> comentarios;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "tb_imagem_post", schema = Constantes.SCHEMA_DESAFIO,
	        joinColumns = {@JoinColumn(name = "id_post")},
	        inverseJoinColumns = {@JoinColumn(name = "id_imagem")}
	)
	private List<Imagem> imagens;

	
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
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * @return the comentarios
	 */
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the imagens
	 */
	public List<Imagem> getImagens() {
		return imagens;
	}

	/**
	 * @param imagens the imagens to set
	 */
	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
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
