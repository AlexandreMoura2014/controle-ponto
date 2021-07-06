package com.dio.live.model;

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
public class Calendario {
	
	@EqualsAndHashCode.Include
	@Id
	private Long id;
	private String nome;
	private String descricao;
	private LocalDateTime dataEspecial;
	
	@ManyToOne
	private TipoData tipoData;

}
