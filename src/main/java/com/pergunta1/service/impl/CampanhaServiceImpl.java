package com.pergunta1.service.impl;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pergunta1.domain.BaseCampanhaDomain;
import com.pergunta1.domain.CampanhaDomain;
import com.pergunta1.entity.CampanhaEntity;
import com.pergunta1.repository.CampanhaRepository;
import com.pergunta1.service.CampanhaService;

/**
 * Esta classe tem a logica dos metodos implementados em
 * CampanhaService
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contato@gustavopolarsa.com
 */
@Service
public class CampanhaServiceImpl implements CampanhaService{

	private final CampanhaRepository repository;
	
	@Autowired
	CampanhaServiceImpl(CampanhaRepository repository) {
        this.repository = repository;
    }
	
	@Override
	public BaseCampanhaDomain create(BaseCampanhaDomain campanhaDomain) {
		CampanhaEntity campanhaEntity = new CampanhaEntity();
		campanhaEntity.setDataVigencia(campanhaDomain.getDataVigencia());
		campanhaEntity.setDataCriacao(LocalDate.now());
		campanhaEntity.setNomeCampanha(campanhaDomain.getNomeCampanha());
		campanhaEntity.setTimeCoracao(campanhaDomain.getTimeCoracao());
		
		List<CampanhaEntity> listCampanhasAtivas = repository.listarCampanhasValidas(campanhaEntity.getDataCriacao());
		
		Comparator<CampanhaEntity> comparator = Comparator.comparing(CampanhaEntity::getDataVigencia); 
		Collections.sort(listCampanhasAtivas, comparator .reversed());
		
		//final LocalDate dataVigencia=todo.getDataVigencia();
		/*listCampanhasAtivas.stream().forEach(x->{
			Boolean validarSomaDias = true;
			while(validarSomaDias){
				x.getDataVigencia().plusDays(1);
				if( x.getDataVigencia().isEqual(dataVIgencia) || listCampanhasAtivas.stream().filter(y -> !x.getId().equals(y.getId()) && y.getDataVigencia().isEqual(x.getDataVigencia())).count()>0){
					x.getDataVigencia().plusDays(1);
				}else{
					update(convertToBaseDomain(x),x.getId());
					validarSomaDias = false;
				}
			}
		});*/
		
		campanhaEntity = repository.save(campanhaEntity);
        return convertToBaseDomain(campanhaEntity);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

	@Override
	public List<CampanhaDomain> findAll() {
		return repository.listarCampanhasValidas(LocalDate.now()).stream()
                .map(this::convertToDomain)
                .collect(toList());
	}

	@Override
	public CampanhaDomain findById(String id) {
		CampanhaEntity campanhaEntity = repository.findOne(id);
		return convertToDomain(campanhaEntity);
	}

	@Override
	public BaseCampanhaDomain update(BaseCampanhaDomain campanha,String id) {
		CampanhaEntity updated = repository.findOne(id);
		updated.setDataVigencia(campanha.getDataVigencia());
		updated.setNomeCampanha(campanha.getNomeCampanha());
		updated.setTimeCoracao(campanha.getTimeCoracao());
        updated = repository.save(updated);
        return convertToBaseDomain(updated);
	}

	private BaseCampanhaDomain convertToBaseDomain(CampanhaEntity entity) {
		BaseCampanhaDomain domain =  new BaseCampanhaDomain(entity.getNomeCampanha(),entity.getTimeCoracao(),entity.getDataVigencia());
         return domain;
    }
	
	private CampanhaDomain convertToDomain(CampanhaEntity entity) {
		CampanhaDomain domain =  new CampanhaDomain(entity.getId(), entity.getNomeCampanha(),entity.getTimeCoracao(),entity.getDataVigencia());
         return domain;
    }
	
}
