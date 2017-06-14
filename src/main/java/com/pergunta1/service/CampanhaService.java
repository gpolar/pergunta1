package com.pergunta1.service;

import java.util.List;

import com.pergunta1.domain.BaseCampanhaDomain;
import com.pergunta1.domain.CampanhaDomain;

/**
 * Esta classe contem a interface de serviço relacionado com os procedimentos da
 * CRUD de campanhas
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contato@gustavopolarsa.com
 */
public interface CampanhaService {

	BaseCampanhaDomain create(BaseCampanhaDomain campanhaDomain);

	void delete(String id);

	List<CampanhaDomain> findAll();

	CampanhaDomain findById(String id);

	BaseCampanhaDomain update(BaseCampanhaDomain campanhaDomain, String id);

}
