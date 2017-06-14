package com.pergunta1.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pergunta1.entity.SocioCampanhaEntity;

/**
 * Esta classe contem a interface da entidade SocioCampanhaEntity para persistir
 * no banco de dados
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contato@gustavopolarsa.com
 */
public interface AssociacaoRepository extends MongoRepository<SocioCampanhaEntity, String> {
	
	List<SocioCampanhaEntity> findBySocioId(String idSocio);
	
}
