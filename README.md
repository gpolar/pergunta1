# Pergunta 1

[![Gps|Gustavopolarsa]()](http://www.gustavopolarsa.com)

O presente projeto é um microserviço que tem o crud de campanhas e associacao

  - Gradle para gerenciar as dependencias e executar os testes
  - Spring boot para subir o server tomcat e facilitar o microservice
  - Eureka Client para que se comunique o server de Eureka principal e faça o registro dos serviços
  - Banco de dados MongoDb foi mais para como questão da facilidade que tem para integrar com o springData,o tempo que teve para desenvolver e a rapidez que trabalha para as consultas e cadastro, e por ultimo ele trabalha bem para sistemas distribuidos( Se bem Cassandra é mais orientado para esse tipo de sistemas, o MongoDb trabalha também bem nesse modelo de arquitectura)
  - Package Hateoas, ele inclui um padrão muito utilizado para gerenciamento de erro que é o vnd erro, ele ao ser um padrão de retorno de erro fica mais facil para as outras aplicações que queram utilizar e gerenciar os erros retornados pela api
  - Swagger para ter os end-point documentados e ter um controle visual dele
  - Mockito Test, para fazer uns testes no serviço
  
Os requisitos Não funcionais 

- Para gerenciar os erro de retorno foi utilizado o vnd erro
- Para medir as 100 requisições por segundo foi utilizado o JMeter o arquivo fica na pasta resources

# Porque microservices

  Porque ajuda a ter um maior controle dos grupos de negocio e manter as funcionalidades deles distribuidas ajudando a independencia dos mesmos, assim o principal de tudo evitando alguma eventual queda de sistema, porque ao ser distribuidos um microservice pode cair mas os outros continuam funcionando, asssim as outras areas de um negocio x, podem continuar funcionando, também ajuda muito agora no tempo onde tudo esta sendo subido nos diferentes servidores cloud(Amazon,Google Cloud,etc). E só para dar uma vantagem a mais( das muitas que tem), cada microservice pode ter um banco, linguagem de programação, etc diferente, porque a comunicação pode ser por Rest, onde o formato json é unico para qualquer tipo de tecnologica.

P.S. Adeia que cada microservice tenha um banco mas para este teste, a pergunta1 e pergunta2 foi colocado no mesmo banco( isso faz a gente só simular a parte dos endereços url diferentes)
  
# Execução
Para subir o projeto num algum IDE é executar o arquivo Application.java
Ele vai pegar a seguinte configuração
```sh
logging:
    level: error
    level.org.springframework.data: debug
server:
    port: 8081
spring:
    data:
        mongodb:
            database: campanha
            host: localhost
            port: 27017
    application:
       name: campanha-service //o alias com que vai ser registrado em eureka
    freemarker:
       enabled: false   
    thymeleaf:
       cache: false
       prefix: classpath:/templates/

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/  //Server de eureka
```
