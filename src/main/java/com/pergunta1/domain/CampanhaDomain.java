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
 * @author: Gustavo Polar gpolars@gmail.com, contact@gustavopolarsa.com
 */
public class CampanhaDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nomeCampanha;
	private Integer timeCoracao;
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonDeserialize(using = ParseDeserializer.class)
	private LocalDate dataVigencia;

	public CampanhaDomain() {
	}
	
	public CampanhaDomain(String id,String nomeCampanha, Integer timeCoracao, LocalDate dataVigencia) {
		this.id = id;
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

	public String getId() {
		return id;
	}
	
}
