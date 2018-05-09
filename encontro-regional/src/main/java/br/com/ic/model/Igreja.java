package br.com.ic.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
public class Igreja implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8017448319879624111L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false, length = 50)
	@NotNull
	private String nome;

	@Column(length = 250)
	private String descricao;
	
	@Builder.Default
	@Column(nullable = false)
	private Boolean ativo = true;
	
	@Builder.Default
	@Column(nullable = false, name = "data_cadastro")
	@NotNull
	private LocalDateTime dataCadastro = LocalDateTime.now();

}
