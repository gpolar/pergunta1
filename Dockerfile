From java:8
EXPOSE 8081
ADD /build/libs/pergunta1-0.1.0.jar  pergunta1-0.1.0.jar
ENTRYPOINT ["java","-jar","pergunta1-0.1.0.jar"]