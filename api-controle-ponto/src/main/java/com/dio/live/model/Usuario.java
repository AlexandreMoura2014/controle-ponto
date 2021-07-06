package com.dio.live.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
public class Usuario {
	
	@EqualsAndHashCode.Include
	@Id
	private Long id;
	private String nome;
	private BigDecimal tolerancia;
	private LocalDateTime inicioJornada;
	private LocalDateTime finalJornada;
	
	@ManyToOne // varios usuarios por uma categoria
	private CategoriaUsuario categoriUsuario;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToOne
	private NivelAcesso nivelAcesso;
	
	@ManyToOne
	private JornadaTrabalho jornadaTrabalho;

}
