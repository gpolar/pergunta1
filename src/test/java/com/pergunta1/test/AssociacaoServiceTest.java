package com.pergunta1.test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.pergunta1.domain.AssociacaoDomain;
import com.pergunta1.entity.SocioCampanhaEntity;
import com.pergunta1.repository.AssociacaoRepository;
import com.pergunta1.service.impl.AssociacaoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AssociacaoServiceTest {

	@InjectMocks
	AssociacaoServiceImpl associacaoServiceImpl;
	
	@Mock
	AssociacaoRepository associacaoRepository;
	
	@Test
	public void findBySocioIdTest(){
		List<SocioCampanhaEntity> lista = new ArrayList<>();
		
		when(associacaoRepository.findBySocioId("abcdef")).thenReturn(lista);
		
		associacaoServiceImpl.findBySocioId("abcdef");
		
		verify(associacaoRepository, times(1)).findBySocioId("abcdef");
		
	}
	
	@Test
	public void convertToDomainTest(){
		SocioCampanhaEntity socioCampanhaEntity = new SocioCampanhaEntity();
		socioCampanhaEntity.setCampanhaId("234234324");
		socioCampanhaEntity.setId("234324324");
		socioCampanhaEntity.setSocioId("543453453");
		
		associacaoServiceImpl.convertToDomain(socioCampanhaEntity);
		
	}
	
	@Test
	public void existeSocioCampanhaTest(){
		AssociacaoDomain associacaoDomain = new AssociacaoDomain("234234324","234234324");
		SocioCampanhaEntity socioCampanhaEntity = new SocioCampanhaEntity();
		socioCampanhaEntity.setCampanhaId("234234324");
		socioCampanhaEntity.setId("234234324");
		socioCampanhaEntity.setSocioId("234234324");
		
		when(associacaoRepository.findByCampanhaIdAndSocioId("234234324","234234324")).thenReturn(Optional.of(socioCampanhaEntity));
		
		associacaoServiceImpl.existeSocioCampanha(associacaoDomain);
		
		verify(associacaoRepository, times(1)).findByCampanhaIdAndSocioId("234234324","234234324");
		
	}
}
