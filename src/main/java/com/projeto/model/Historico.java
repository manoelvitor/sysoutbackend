package com.projeto.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "historico_os")
public class Historico extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Situacao situacao;

	private String informacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "UTC")
	private LocalDateTime data = LocalDateTime.now();

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public String getInformacao() {
		return informacao;
	}

	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Historico() {

	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Historico(Situacao situacao, String informacao) {
		this.situacao = situacao;
		this.informacao = informacao;
	}

}
