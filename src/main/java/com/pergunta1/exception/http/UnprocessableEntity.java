package com.pergunta1.exception.http;

import org.springframework.http.HttpStatus;

public class UnprocessableEntity extends ExcecoesHttp {

	private static final long serialVersionUID = 1L;

	public UnprocessableEntity(){
		super("Entidade não pode ser processada");
	}
	
	public UnprocessableEntity(String message){
		super(message,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	
}
