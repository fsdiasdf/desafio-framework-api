/**
 *
 */
package br.com.desafioFramework.entity;

import java.time.LocalDate;
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
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.desafioFramework.util.Constantes;

/**
 * @author Felipe Dias
 *
 */
@Entity
@Table(name = "tb_album", schema = Constantes.SCHEMA_DESAFIO)
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_album")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Column(name = "ds_titulo", nullable = false)
	private String titulo;

	@Column(name = "dt_criacao", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate publicacao;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "tb_imagem_album", schema = Constantes.SCHEMA_DESAFIO,
	        joinColumns = {@JoinColumn(name = "id_album")},
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
