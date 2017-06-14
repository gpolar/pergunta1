package com.pergunta1.domain;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.pergunta1.convert.ParseDeserializer;

/**
 * Esta classe tem o CampanhaDomain que serve de parse entre a entidade e o
 * cliente
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contato@gustavopolarsa.com
 */
public class BaseCampanhaDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeCampanha;
	private Integer timeCoracao;
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonDeserialize(using = ParseDeserializer.class)
	private LocalDate dataVigencia;

	public BaseCampanhaDomain() {
	}
	
	public BaseCampanhaDomain(String nomeCampanha, Integer timeCoracao, LocalDate dataVigencia) {
		this.nomeCampanha = nomeCampanha;
		this.timeCoracao = timeCoracao;
		this.dataVigencia = dataVigencia;
	}

	public String getNomeCampanha() {
		return nomeCampanha;
	}

	public Integer getTimeCoracao() {
		return timeCoracao;
	}

	public LocalDate getDataVigencia() {
		return dataVigencia;
	}
	
}
