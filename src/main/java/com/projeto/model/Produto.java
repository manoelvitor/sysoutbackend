package com.projeto.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Produto extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@NotBlank 
	private Long idEmpresa;
	@NotBlank 
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private String categoria;
	private String codigo;
	
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
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Produto() {
	}
	
	
	
	
	
}
