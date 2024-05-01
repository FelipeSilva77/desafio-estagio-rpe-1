# **Desafio - RPE TECH**

## Tecnologias utilizadas

* Java 17;
* Maven;
* Spring Boot;
* Spring Data;
* PostgreSQL;
* Swagger;
* JUnit;

## Execução do projeto
```
docker build -t rpe/cadastropessoa .
```
e no arquivo docker-compose.yml altera no service app a imagem builda colocar mesmo nome usado no build `felipe/cadastropessoa`

depois exeutar `docker-compose up -d`

abrir swagger em locahost:8082/swagger-ui/index.html
