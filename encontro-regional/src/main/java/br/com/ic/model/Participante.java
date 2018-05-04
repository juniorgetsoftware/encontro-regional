package br.com.ic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

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
public class Participante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6781428531228911918L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true, nullable = false, length = 50)
	private String nome;

	@NotBlank
	@ManyToOne(optional = false)
	private Igreja igreja;

	@NotBlank
	@ManyToOne(optional = false)
	private Cargo cargo;

	@NotBlank
	@Type(type = "true_false")
	private boolean primeiraVezEmEncontroRegional;

}
