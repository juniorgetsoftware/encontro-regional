package br.com.ic.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.annotations.Type;

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
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7078447290463083596L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false, length = 50)
	@NotBlank
	private String nome;

	@Column(length = 250)
	private String descricao;

	@Type(type = "true_false")
	@Column(nullable = false)
	private Boolean ativo = true;
	
	@Column(nullable = false, name = "data_cadastro")
	@PastOrPresent
	@NotBlank
	private LocalDateTime dataCadastro = LocalDateTime.now();

}
