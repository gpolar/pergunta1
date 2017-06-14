package com.pergunta1.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.hateoas.VndErrors.VndError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Esta classe vai ter as possiveis exeções que poderiam acontecer ao consumir
 * um serviço retornando todo no padrão application/vnd.error+json
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contato@gustavopolarsa.com
 */
@RestControllerAdvice
public class Excecoes {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public VndError constraintViolationException(ConstraintViolationException exception) {
		return criarMensagem(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
	}

	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public VndError illegalStateException(IllegalStateException exception) {
		return criarMensagem(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public VndError illegalArgumentException(IllegalArgumentException exception) {
		return criarMensagem(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
	}

	private VndError criarMensagem(Integer status, String mensagem) {
		return new VndError(status.toString(), mensagem);

	}

}
