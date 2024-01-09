package com.projeto.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.model.enums.StatusOrdemServico;

import ch.qos.logback.core.status.Status;


@Entity
public class OrdemServico extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	private Long idEmpresa;
	private StatusOrdemServico status;
	@ManyToOne
	private Cliente cliente;
	private Long nrOrdemServico;
	private String marca;
	private String modelo;
	private String nrSerie;
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Situacao situacaoAtual;
	@ManyToMany
	private List<Acessorio> acessorios;
	private String dsDefeitoCliente;
	private String dsDefeitoTecnico;
	private Boolean orcamentoAprovado;
	@ManyToMany
	private List<Servico> servicosEfetuados;
	private String pecaReparo;
	private BigDecimal precoPecaReparo;
	private BigDecimal valorOrcamento;
	private BigDecimal valorTotal;
	private String osbservacao;
	@ManyToOne
	private Usuario tecnicoResponsavel;
	@ManyToOne
	private Usuario tecnicoResponsavelAnterior;
	@OneToMany
	private List<Historico> historico = new ArrayList<Historico>();
	@ManyToMany
	private List<Produto> produtos = new ArrayList<Produto>();
	@ManyToOne
	private InformacoesTecnicaOs infoTec;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "UTC")
	private LocalDateTime dataEntrada = LocalDateTime.now();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "UTC")
	private LocalDateTime dataSaida;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "UTC")
	private LocalDateTime dataRepasse;	
	private String cor;
	private BigDecimal valorDesconto;

	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public LocalDateTime getDataRepasse() {
		return dataRepasse;
	}

	public void setDataRepasse(LocalDateTime dataRepasse) {
		this.dataRepasse = dataRepasse;
	}
	
	public Long getNrOrdemServico() {
		return nrOrdemServico;
	}

	public void setNrOrdemServico(Long nrOrdemServico) {
		this.nrOrdemServico = nrOrdemServico;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNrSerie() {
		return nrSerie;
	}

	public void setNrSerie(String nrSerie) {
		this.nrSerie = nrSerie;
	}

	public String getDsDefeitoCliente() {
		return dsDefeitoCliente;
	}

	public void setDsDefeitoCliente(String dsDefeitoCliente) {
		this.dsDefeitoCliente = dsDefeitoCliente;
	}

	public String getDsDefeitoTecnico() {
		return dsDefeitoTecnico;
	}

	public void setDsDefeitoTecnico(String dsDefeitoTecnico) {
		this.dsDefeitoTecnico = dsDefeitoTecnico;
	}

	public Boolean getOrcamentoAprovado() {
		return orcamentoAprovado;
	}

	public void setOrcamentoAprovado(Boolean orcamentoAprovado) {
		this.orcamentoAprovado = orcamentoAprovado;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getOsbservacao() {
		return osbservacao;
	}

	public void setOsbservacao(String osbservacao) {
		this.osbservacao = osbservacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public OrdemServico() {
	}
	
	public Usuario getTecnicoResponsavel() {
		return tecnicoResponsavel;
	}

	public void setTecnicoResponsavel(Usuario tecnicoResponsavel) {
		this.tecnicoResponsavel = tecnicoResponsavel;
	}

	public Usuario getTecnicoResponsavelAnterior() {
		return tecnicoResponsavelAnterior;
	}

	public void setTecnicoResponsavelAnterior(Usuario tecnicoResponsavelAnterior) {
		this.tecnicoResponsavelAnterior = tecnicoResponsavelAnterior;
	}

	public List<Historico> getHistorico() {
		return historico;
	}

	public void setHistorico(List<Historico> historico) {
		this.historico = historico;
	}

	public InformacoesTecnicaOs getInfoTec() {
		return infoTec;
	}

	public void setInfoTec(InformacoesTecnicaOs infoTec) {
		this.infoTec = infoTec;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Situacao getSituacaoAtual() {
		return situacaoAtual;
	}

	public void setSituacaoAtual(Situacao situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public List<Servico> getServicosEfetuados() {
		return servicosEfetuados;
	}

	public void setServicosEfetuados(List<Servico> servicosEfetuados) {
		this.servicosEfetuados = servicosEfetuados;
	}

	public String getPecaReparo() {
		return pecaReparo;
	}

	public void setPecaReparo(String pecaReparo) {
		this.pecaReparo = pecaReparo;
	}

	public BigDecimal getPrecoPecaReparo() {
		return precoPecaReparo;
	}

	public void setPrecoPecaReparo(BigDecimal precoPecaReparo) {
		this.precoPecaReparo = precoPecaReparo;
	}

	public BigDecimal getValorOrcamento() {
		return valorOrcamento;
	}

	public void setValorOrcamento(BigDecimal valorOrcamento) {
		this.valorOrcamento = valorOrcamento;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}	
	
	public StatusOrdemServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}

	
	
	
	
}
