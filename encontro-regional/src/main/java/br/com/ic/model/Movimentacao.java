package br.com.ic.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.annotations.Type;

import br.com.ic.model.enums.TipoMovimentacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = { "id" })
@Builder
@AllArgsConstructor
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1354884467816601433L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true, nullable = false, length = 50)
	private String titulo;

	@Column(length = 250)
	private String observacao;

	@NotBlank
	@Column(nullable = false)
	@DecimalMin(value = "0.01")
	private BigDecimal valor;

	@Column(nullable = true, name = "data_pagamento")
	@NotBlank
	private LocalDate dataPagamento;

	@Column(nullable = false, name = "data_vencimento")
	@NotBlank
	private LocalDate dataVencimento;

	@Column(nullable = false, name = "data_cadastro")
	@PastOrPresent
	@NotBlank
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoMovimentacao tipo;

	@ManyToOne(optional = false)
	private Categoria categoria;

	@Type(type = "true_false")
	@Column(nullable = false)
	private Boolean ativo = true;

}
