package com.pergunta1.domain;

import java.io.Serializable;

/**
 * Esta classe tem o AssociacaoDomain que serve de parse entre a entidade e o
 * cliente
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contact@gustavopolarsa.com
 */
public class AssociacaoDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	private String socioId;
	private String campanhaId;

	public AssociacaoDomain() {
	}

	public AssociacaoDomain(String socioId, String campanhaId) {
		this.socioId = socioId;
		this.campanhaId = campanhaId;
	}

	public String getSocioId() {
		return socioId;
	}

	public String getCampanhaId() {
		return campanhaId;
	}
	

}
