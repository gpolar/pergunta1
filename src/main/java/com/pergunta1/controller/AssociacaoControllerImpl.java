package com.pergunta1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pergunta1.domain.AssociacaoDomain;
import com.pergunta1.service.AssociacaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Esta classe implementa end-point
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contato@gustavopolarsa.com
 */
@RestController
@RequestMapping("/associacao")
@Api(basePath = "/associacao", value = "Associar", description = "Associar campanhas com o cliente", produces = "application/json")
public class AssociacaoControllerImpl{

	private final AssociacaoService service;

	@Autowired
	AssociacaoControllerImpl(AssociacaoService service) {
		this.service = service;
	}

	/**
	 * Método tem a lógica para associar campanhas
	 * 
	 * @param associacaoDomain
	 * @return AssociacaoDomain
	 */
	@PostMapping
	@ApiOperation(value = "Associar campanhas com o cliente", notes = "Associar campanhas com o cliente")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 201, message = "Associacao Feita") })
	public AssociacaoDomain adicionarCampanhas(@RequestBody AssociacaoDomain associacaoDomain) {
		return service.create(associacaoDomain);
	}

	/**
	 * Método que busca as campanhas associadas de um socio torcedor
	 * 
	 * @param associacaoDomain
	 * @return AssociacaoDomain
	 */
	@GetMapping("/{socioId}")
	@ApiOperation(value = "Busca Campanhas por Socio", notes = "Busca Campanhas por Socio")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 201, message = "Campanhas por socio listadas") })
	public List<AssociacaoDomain> listarCampanhasPorSocio(@PathVariable("socioId")String socioId) {
		// TODO Auto-generated method stub
		return service.findBySocioId(socioId);
	}

}
