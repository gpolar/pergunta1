package com.pergunta1.service;

import java.util.List;

import com.pergunta1.domain.AssociacaoDomain;

/**
 * Esta classe contem a interface de serviço relacionado com os procedimentos de
 * associação
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contato@gustavopolarsa.com
 */
public interface AssociacaoService {

	AssociacaoDomain create(AssociacaoDomain associacao);
	
	List<AssociacaoDomain> findBySocioId(String socioId);

}
