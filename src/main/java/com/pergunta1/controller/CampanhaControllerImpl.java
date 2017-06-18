package com.pergunta1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pergunta1.domain.BaseCampanhaDomain;
import com.pergunta1.domain.CampanhaDomain;
import com.pergunta1.service.CampanhaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Esta classe implementa os end-point
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contact@gustavopolarsa.com
 */
@RestController
@RequestMapping("/campanha")
@Api(basePath = "/campanha", value = "Campanha", description = "Crud de campanhas", produces = "application/json")
public class CampanhaControllerImpl {

	private final CampanhaService service;

	@Autowired
	CampanhaControllerImpl(CampanhaService service) {
		this.service = service;
	}

	/**
	 * Método tem a lógica para listar campanhas
	 * 
	 * @return List<CampanhaDomain>
	 */
	@GetMapping
	@ApiOperation(value = "Listar Campanhas Ativas", notes = "Listar Campanhas Ativas")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 201, message = "Campanha Listada") })
	public List<CampanhaDomain> listarCampanhas() {
		return service.findAll();
	}

	/**
	 * Método tem a lógica para adicionar campanhas
	 * 
	 * @param campanhaDomain
	 * @return CampanhaDomain
	 */
	@PostMapping
	@ApiOperation(value = "Adicionar Campanhas", notes = "Adicionar Campanhas")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 201, message = "Campanha Cadastrada") })
	public BaseCampanhaDomain adicionarCampanhas(@RequestBody BaseCampanhaDomain campanhaDomain) {
		return service.create(campanhaDomain);
	}

	/**
	 * Método tem a lógica para adicionar campanhas
	 * 
	 * @param campanhaDomain
	 * @return CampanhaDomain
	 */
	@PutMapping("/{campanhaId}")
	@ApiOperation(value = "Atualizar Campanhas", notes = "Atualizar Campanhas")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 201, message = "Atualizar Listada") })
	public BaseCampanhaDomain atualizarCampanhas(@PathVariable("campanhaId")String campanhaId,@RequestBody BaseCampanhaDomain campanhaDomain) {
		return service.update(campanhaDomain, campanhaId);
	}

	/**
	 * Método tem a lógica para remover campanhas
	 * 
	 * @param campanhaId
	 */
	@DeleteMapping("/{campanhaId}")
	@ApiOperation(value = "Remover Campanha", notes = "Remover Campanha")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 201, message = "Campanha Removida") })
	public void removerCampanhas(@PathVariable("campanhaId")String campanhaId) {
		service.delete(campanhaId);
	}

}
