package com.pergunta1.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pergunta1.domain.AssociacaoDomain;
import com.pergunta1.entity.SocioCampanhaEntity;
import com.pergunta1.repository.AssociacaoRepository;
import com.pergunta1.service.AssociacaoService;

/**
 * Esta classe tem a logica dos metodos implementados em
 * AssociacaoService
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contato@gustavopolarsa.com
 */
@Service
public class AssociacaoServiceImpl implements AssociacaoService {

	private final AssociacaoRepository repository;

	@Autowired
	AssociacaoServiceImpl(AssociacaoRepository repository) {
		this.repository = repository;
	}

	@Override
	public AssociacaoDomain create(AssociacaoDomain associacao) {
		SocioCampanhaEntity socioCampanhaEntity = new SocioCampanhaEntity();
		socioCampanhaEntity.setCampanhaId(associacao.getCampanhaId());
		socioCampanhaEntity.setSocioId(associacao.getSocioId());

		socioCampanhaEntity = repository.save(socioCampanhaEntity);
		return convertToDomain(socioCampanhaEntity);
	}

	@Override
	public List<AssociacaoDomain> findBySocioId(String socioId) {
		return repository.findBySocioId(socioId).stream().map(x -> convertToDomain(x)).collect(Collectors.toList());
	}
	
	private AssociacaoDomain convertToDomain(SocioCampanhaEntity entity) {
		AssociacaoDomain domain = new AssociacaoDomain(entity.getCampanhaId(), entity.getSocioId());
		return domain;
	}

}
