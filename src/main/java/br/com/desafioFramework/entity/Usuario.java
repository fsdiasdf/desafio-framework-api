/**
 * 
 */
package br.com.desafioFramework.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import br.com.desafioFramework.util.Constantes;

/**
 * @author Felipe Dias
 *
 */
@Entity
@Table(name = "tb_usuario", schema = Constantes.SCHEMA_DESAFIO)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer id;
	
	@Column(name = "ds_nome", nullable = false)
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@Column(name = "nm_usuario", unique = true)
	@NotEmpty(message = "{campo.login.obrigatorio}")
	private String username;
	
	@Column(name = "ds_senha", nullable = false)
	@NotEmpty(message = "{campo.senha.obrigatorio}")
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tb_usuario_roles", schema = Constantes.SCHEMA_DESAFIO, joinColumns = @JoinColumn(name = "id_usuario"))
	@Column(name = "ds_role")
	private List<String> roles = new ArrayList<String>();

	@OneToMany(mappedBy = "usuario")
	private List<Post> posts;
	
	@OneToMany(mappedBy = "usuario")
	private List<Album> albuns;

	
	public Usuario() {
		
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	
}
