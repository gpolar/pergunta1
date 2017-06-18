package com.pergunta1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Esta classe inicia a configuração do Swagger para ter os serviços rest
 * documentados
 * 
 * @author: Gustavo Polar gpolars@gmail.com, contact@gustavopolarsa.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Campanha").apiInfo(apiInfo()).select()
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("Gustavo Polar", "http://www.gustavopolarsa.com", "contact@gustavopolarsa.com");

		return new ApiInfoBuilder().title("EndPoint rest para a Crud de campanha")
				.description("serviços para consultar campanhas").termsOfServiceUrl("http://www.gustavopolarsa.com")
				.contact(contact).license("Versão 1.0").licenseUrl("https://www.gustavopolarsa.com").version("2.0")
				.build();
	}

}
