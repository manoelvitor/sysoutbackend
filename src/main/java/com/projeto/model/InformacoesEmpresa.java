package com.projeto.model;

import javax.persistence.Entity;

@Entity
public class InformacoesEmpresa extends AbstractEntity {
	

	private static final long serialVersionUID = 1L;
	String nomeFantasia;
	String razaoSocial;
	String cnpj;
	String slogan;
	String endereco;
	String urlLogoTipo;
	String telefone;
	String email;
	String site;
	
	public InformacoesEmpresa() {
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getUrlLogoTipo() {
		return urlLogoTipo;
	}

	public void setUrlLogoTipo(String urlLogoTipo) {
		this.urlLogoTipo = urlLogoTipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
		
	
}
