package com.pergunta1.exception.http;

import org.springframework.http.HttpStatus;

public class BadRequestEntity extends ExcecoesHttp {

	private static final long serialVersionUID = 1L;

	public BadRequestEntity(){
		super("Entidade não pode ser processada");
	}
	
	public BadRequestEntity(String message){
		super(message,HttpStatus.BAD_REQUEST);
	}
	
	
}
