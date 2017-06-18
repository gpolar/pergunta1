package com.pergunta1.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esta classe tem o CampanhaEntity que é a entidade que vai persistir no banco
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contact@gustavopolarsa.com
 */
@Document(collection = "campanha")
public class CampanhaEntity {

	@Id
	private String id;
	
	private String nomeCampanha;
	private Integer timeCoracao;
	private LocalDate dataCriacao;
	private LocalDate dataVigencia;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomeCampanha() {
		return nomeCampanha;
	}
	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}
	public Integer getTimeCoracao() {
		return timeCoracao;
	}
	public void setTimeCoracao(Integer timeCoracao) {
		this.timeCoracao = timeCoracao;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDate getDataVigencia() {
		return dataVigencia;
	}
	public void setDataVigencia(LocalDate dataVigencia) {
		this.dataVigencia = dataVigencia;
	}
		
}
