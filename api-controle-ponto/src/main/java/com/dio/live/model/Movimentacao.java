package com.dio.live.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.dio.live.model.embeddable.MovimentacaoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movimentacao {

	@EmbeddedId 
	@Id
	private MovimentacaoId id;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private BigDecimal periodo;
	
	@ManyToOne
	private Ocorrencia ocorrencia;
	
	@ManyToOne
	private Calendario calendario;

}
