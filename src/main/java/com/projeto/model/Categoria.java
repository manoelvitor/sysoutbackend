package com.projeto.model;

import javax.persistence.Entity;

@Entity
public class Categoria extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String descricao;
	private Long idEmpresa;

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
	public Categoria() {
	}
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	
	
}
