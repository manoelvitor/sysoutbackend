package com.projeto.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.projeto.model.TipoPerfil;

public enum StatusOrdemServico {
	 	ABERTA(1,"Aberta"), 
	    EM_ANDAMENTO(2,"Em andamento"), 
	    PENDENTE(3,"Pendente"),
	    CONCLUIDA(4,"Concluída"), 
	    CANCELADA(5,"Cancelada");
	    
	private Integer cod;
	private String descricao;

	StatusOrdemServico(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public static StatusOrdemServico toEnum(Integer cod) {
		if (cod == null)
			return null;
		for (StatusOrdemServico x : StatusOrdemServico.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}
		throw new IllegalArgumentException("Código inválido: " + cod);
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	
	
	    


}
