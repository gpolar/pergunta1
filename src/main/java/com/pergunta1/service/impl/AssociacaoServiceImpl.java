package com.pergunta1.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pergunta1.domain.AssociacaoDomain;
import com.pergunta1.entity.SocioCampanhaEntity;
import com.pergunta1.exception.http.UnprocessableEntity;
import com.pergunta1.repository.AssociacaoRepository;
import com.pergunta1.repository.CampanhaRepository;
import com.pergunta1.service.AssociacaoService;

/**
 * Esta classe tem a logica dos metodos implementados em AssociacaoService
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contact@gustavopolarsa.com
 */
@Service
public class AssociacaoServiceImpl implements AssociacaoService {

	private final AssociacaoRepository associacaoRepository;
	private final CampanhaRepository campanhaRepository;

	@Autowired
	AssociacaoServiceImpl(AssociacaoRepository associacaoRepository, CampanhaRepository campanhaRepository) {
		this.associacaoRepository = associacaoRepository;
		this.campanhaRepository = campanhaRepository;
	}

	@Override
	public AssociacaoDomain create(AssociacaoDomain associacao) {
		if (Objects.nonNull(campanhaRepository.findOne(associacao.getCampanhaId())) && !existeSocioCampanha(associacao)) {
			SocioCampanhaEntity socioCampanhaEntity = new SocioCampanhaEntity();
			socioCampanhaEntity.setCampanhaId(associacao.getCampanhaId());
			socioCampanhaEntity.setSocioId(associacao.getSocioId());

			socioCampanhaEntity = associacaoRepository.save(socioCampanhaEntity);
			return convertToDomain(socioCampanhaEntity);
		}
		throw new UnprocessableEntity("Associação tem dados invalidos");
	}

	@Override
	public List<AssociacaoDomain> findBySocioId(String socioId) {
		return associacaoRepository.findBySocioId(socioId).stream().map(x -> convertToDomain(x))
				.collect(Collectors.toList());
	}

	public AssociacaoDomain convertToDomain(SocioCampanhaEntity entity) {
		AssociacaoDomain domain = new AssociacaoDomain(entity.getSocioId(), entity.getCampanhaId());
		return domain;
	}
	
	public Boolean existeSocioCampanha(AssociacaoDomain associacao){
		return Objects.isNull(associacaoRepository
		.findByCampanhaIdAndSocioId(associacao.getCampanhaId(), associacao.getSocioId()).orElse(null)) ? false : true;
	}

}
