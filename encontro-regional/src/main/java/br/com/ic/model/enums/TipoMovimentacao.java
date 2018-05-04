package br.com.ic.model.enums;

import lombok.Getter;

public enum TipoMovimentacao {

	ENTRADA("Entrada"), SAIDA("Saída");

	private TipoMovimentacao(String descricao) {
		this.descricao = descricao;
	}

	@Getter
	private String descricao;

}
