package com.projeto.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Acessorio extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@NotBlank 
	private Long idEmpresa;
	@NotBlank 
	private String nome;
	private String descricao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	public Acessorio() {
	}
	
	
	
}
