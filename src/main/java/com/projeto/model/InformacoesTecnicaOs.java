package com.projeto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.projeto.model.enums.TipoMemoriaRam;

@Entity
@Table(name = "tb_info_tec")
public class InformacoesTecnicaOs extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	private Long idEmpresa;
	
	private Boolean hardDisk;
	
	private Boolean ssd;
	
	private Double tamArmazanamento;
	
	private Double velocDiscPrincipal;
	
	private Double tamMemoriaRam;
	
	private TipoMemoriaRam tpMemoriaRam;
	
	private String processador;
	
	private String sistemaOp;
	
	private Double tempProcessador;
	
	private String placaVideo;
	
	private Integer voltEntrada;
	
	private Double tamMonitor;
	
	private String placaMae;

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Boolean getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(Boolean hardDisk) {
		this.hardDisk = hardDisk;
	}

	public Boolean getSsd() {
		return ssd;
	}

	public void setSsd(Boolean ssd) {
		this.ssd = ssd;
	}

	public Double getTamArmazanamento() {
		return tamArmazanamento;
	}

	public void setTamArmazanamento(Double tamArmazanamento) {
		this.tamArmazanamento = tamArmazanamento;
	}

	public Double getVelocDiscPrincipal() {
		return velocDiscPrincipal;
	}

	public void setVelocDiscPrincipal(Double velocDiscPrincipal) {
		this.velocDiscPrincipal = velocDiscPrincipal;
	}

	public Double getTamMemoriaRam() {
		return tamMemoriaRam;
	}

	public void setTamMemoriaRam(Double tamMemoriaRam) {
		this.tamMemoriaRam = tamMemoriaRam;
	}

	public TipoMemoriaRam getTpMemoriaRam() {
		return tpMemoriaRam;
	}

	public void setTpMemoriaRam(TipoMemoriaRam tpMemoriaRam) {
		this.tpMemoriaRam = tpMemoriaRam;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getSistemaOp() {
		return sistemaOp;
	}

	public void setSistemaOp(String sistemaOp) {
		this.sistemaOp = sistemaOp;
	}

	public Double getTempProcessador() {
		return tempProcessador;
	}

	public void setTempProcessador(Double tempProcessador) {
		this.tempProcessador = tempProcessador;
	}

	public String getPlacaVideo() {
		return placaVideo;
	}

	public void setPlacaVideo(String placaVideo) {
		this.placaVideo = placaVideo;
	}

	public Integer getVoltEntrada() {
		return voltEntrada;
	}

	public void setVoltEntrada(Integer voltEntrada) {
		this.voltEntrada = voltEntrada;
	}

	public Double getTamMonitor() {
		return tamMonitor;
	}

	public void setTamMonitor(Double tamMonitor) {
		this.tamMonitor = tamMonitor;
	}

	public String getPlacaMae() {
		return placaMae;
	}

	public void setPlacaMae(String placaMae) {
		this.placaMae = placaMae;
	}

	public InformacoesTecnicaOs() {
	}

//	public InformacoesTecnicaOs(Boolean hardDisk, Boolean ssd, Double tamArmazanamento, Double velocDiscPrincipal,Double tamMemoriaRam, TipoMemoriaRam tpMemoriaRam, String processador, String sistemaOp, Double tempProcessador, String placaVideo, Integer voltEntrada, Double tamMonitor, String placaMae) {
//		this.hardDisk = hardDisk;
//		this.ssd = ssd;
//		this.tamArmazanamento = tamArmazanamento;
//		this.velocDiscPrincipal = velocDiscPrincipal;
//		this.tamMemoriaRam = tamMemoriaRam;
//		this.tpMemoriaRam = tpMemoriaRam;
//		this.processador = processador;
//		this.sistemaOp = sistemaOp;
//		this.tempProcessador = tempProcessador;
//		this.placaVideo = placaVideo;
//		this.voltEntrada = voltEntrada;
//		this.tamMonitor = tamMonitor;
//		this.placaMae = placaMae;
//	}

	

}
