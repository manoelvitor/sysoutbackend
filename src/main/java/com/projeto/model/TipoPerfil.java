package com.projeto.model;

public enum TipoPerfil {
	ADMIN(1, "ROLE_ADMIN"), TECNICO(2, "ROLE_TECNICO");

	private Integer cod;
	private String descricao;

	private TipoPerfil(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoPerfil toEnum(Integer cod) {
		if (cod == null)
			return null;
		for (TipoPerfil x : TipoPerfil.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}
		throw new IllegalArgumentException("Código inválido: " + cod);
	}
}