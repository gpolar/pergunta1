package com.pergunta1.exception.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Esta classe vai ter as possiveis exeções que poderiam acontecer ao consumir
 * um serviço retornando todo no padrão application/vnd.error+json
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contact@gustavopolarsa.com
 */
@RestControllerAdvice
public class ExcecoesHttp extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private HttpStatus status;
	
	public ExcecoesHttp() {
		super();
	}

	public ExcecoesHttp(String message){
		this.message = message;
		this.status = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	public ExcecoesHttp(String message,HttpStatus httpstatus){
		this.message = message;
		this.status = httpstatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
