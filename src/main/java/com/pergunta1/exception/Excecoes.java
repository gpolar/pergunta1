package com.pergunta1.exception;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.VndErrors.VndError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pergunta1.exception.http.ExcecoesHttp;

/**
 * Esta classe vai ter as possiveis exeções que poderiam acontecer ao consumir
 * um serviço retornando todo no padrão application/vnd.error+json
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contact@gustavopolarsa.com
 */
@RestControllerAdvice
public class Excecoes {

	private static final Logger logger = LoggerFactory.getLogger(Excecoes.class);
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public VndError constraintViolationException(ConstraintViolationException exception) {
		return criarMensagem(HttpStatus.BAD_REQUEST.value(), exception);
	}

	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public VndError illegalStateException(IllegalStateException exception) {
		return criarMensagem(HttpStatus.BAD_REQUEST.value(), exception);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public VndError illegalArgumentException(IllegalArgumentException exception) {
		return criarMensagem(HttpStatus.BAD_REQUEST.value(), exception);
	}

	/*Metodo para mostrar mais amigavel alguns erros http*/
	@ExceptionHandler(ExcecoesHttp.class)
	public ResponseEntity<?> excecoesHttp(ExcecoesHttp exception) {
		return new ResponseEntity<>(criarMensagem(exception.getStatus().value(), exception),exception.getStatus());
	}
	
	private VndError criarMensagem(Integer status, RuntimeException exception) {
		logger.error(exception.getMessage(),exception);
		return new VndError(status.toString(), exception.getMessage());

	}

}
