package com.dio.live.model.embeddable;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Embeddable
public class BancoHoraId implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@EqualsAndHashCode.Include
	private Long idBancoHoras;
	
	@EqualsAndHashCode.Include
	private Long idMovimentacao;
	
	@EqualsAndHashCode.Include
	private Long idCliente;
}
