package com.projeto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Situacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private Long idEmpresa;
	private String nome;
	private String descricao;
	
	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

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

	public Situacao() {
	
	}
	
	

}
