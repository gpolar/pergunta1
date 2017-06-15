package com.pergunta1.test;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.pergunta1.domain.BaseCampanhaDomain;
import com.pergunta1.entity.CampanhaEntity;
import com.pergunta1.repository.CampanhaRepository;
import com.pergunta1.service.impl.CampanhaServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class CampanhaServiceTest {

	@InjectMocks
	CampanhaServiceImpl campanhaServiceImpl;
	
	@Mock
	CampanhaRepository campanhaRepository;
	
	CampanhaEntity campanhaEntity;
	
	BaseCampanhaDomain campanhaDomain;
	
	@Before
	public void setup(){
		campanhaEntity = new CampanhaEntity();
		campanhaEntity.setDataCriacao(LocalDate.now());
		campanhaEntity.setId("12345");
		campanhaEntity.setNomeCampanha("teste");
		campanhaEntity.setTimeCoracao(7);
		
		campanhaDomain = new BaseCampanhaDomain("Teste", 4, LocalDate.now());
	}
	
	@Test
	public void findBySocioIdTest(){
		
		
		when(campanhaRepository.save(Matchers.any(CampanhaEntity.class))).thenReturn(campanhaEntity);
		
		campanhaServiceImpl.create(campanhaDomain);
		
		verify(campanhaRepository, times(1)).save(Matchers.any(CampanhaEntity.class));
		
	}
	
	@Test
	public void deleteTest(){
		
		when(campanhaRepository.findOne(Matchers.anyString())).thenReturn(campanhaEntity);
		Mockito.doNothing().when(campanhaRepository).delete(Matchers.anyString());
		
		campanhaServiceImpl.delete("abcde");
		
		verify(campanhaRepository, times(1)).findOne(Matchers.anyString());
		verify(campanhaRepository, times(1)).delete(Matchers.anyString());
		
	}
	
	@Test
	public void findAllTest(){
		List<CampanhaEntity> campanhaDomain = new ArrayList<>();
		
		when(campanhaRepository.listarCampanhasValidas(LocalDate.now())).thenReturn(campanhaDomain);
		
		campanhaServiceImpl.findAll();
		
		verify(campanhaRepository, times(1)).listarCampanhasValidas(LocalDate.now());
		
	}
	
	@Test
	public void findByIdTest(){
		when(campanhaRepository.findOne(Matchers.anyString())).thenReturn(campanhaEntity);
		
		campanhaServiceImpl.findById("abcde");
		
		verify(campanhaRepository, times(1)).findOne(Matchers.anyString());
		
	}
	
	@Test
	public void updateTest(){
		when(campanhaRepository.findOne(Matchers.anyString())).thenReturn(campanhaEntity);
		when(campanhaRepository.save(Matchers.any(CampanhaEntity.class))).thenReturn(campanhaEntity);
		
		campanhaServiceImpl.update(campanhaDomain,"345345");
		
		verify(campanhaRepository, times(1)).findOne(Matchers.anyString());
		verify(campanhaRepository, times(1)).save(Matchers.any(CampanhaEntity.class));
		
	}
	
	
	
}
