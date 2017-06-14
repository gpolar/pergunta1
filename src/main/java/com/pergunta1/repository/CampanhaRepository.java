package com.pergunta1.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pergunta1.entity.CampanhaEntity;

/**
 * Esta classe contem a interface da entidade CampanhaEntity para persistir no
 * banco de dados
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contato@gustavopolarsa.com
 */
public interface CampanhaRepository extends MongoRepository<CampanhaEntity, String> {

	@Query("{ 'dataCriacao' : { $lte: ?0 }, 'dataVigencia' : { $gte: ?0 } }, $orderby: { dataVigencia : 1 } ")
	List<CampanhaEntity> listarCampanhasValidas(LocalDate dataAtual);
}
