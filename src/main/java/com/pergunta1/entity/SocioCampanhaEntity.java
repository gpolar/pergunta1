package com.pergunta1.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esta classe tem o SocioCampanhaEntity que é a entidade que vai persistir no
 * banco
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contato@gustavopolarsa.com
 */
@Document(collection = "socioCampanha")
public class SocioCampanhaEntity {

	@Id
	private String id;

	private String socioId;

	private String campanhaId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSocioId() {
		return socioId;
	}

	public void setSocioId(String socioId) {
		this.socioId = socioId;
	}

	public String getCampanhaId() {
		return campanhaId;
	}

	public void setCampanhaId(String campanhaId) {
		this.campanhaId = campanhaId;
	}
	
}
