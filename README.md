# **Desafio - RPE TECH**

## Tecnologias utilizadas

* Java 17;
* Maven;
* Spring Boot;
* Spring Data;
* Spring Security;
* PostgreSQL;
* Swagger;
* JUnit;
* Docker;

## Execução do projeto
Para executar o projeto siga as instruções a seguir:

Ao entrar no Bash, clone o repositório com o comando:

'git clone https://github.com/FelipeSilva77/desafio-estagio-rpe-1.git'

Logo após, abra o projeto em uma IDE( nesse caso eu utilizei), aguardando baixar as dependências necessárias para executar o projeto.

Sobre o Banco de Dados, utilizei o PostgreSQL, nele faça a alteração das variáveis de ambiente no arquivo application.properties, configurando
 o local, no caso o nome de usuário e a senha do banco de dados.
```
docker build -t rpe/cadastropessoa .
```
e no arquivo docker-compose.yml altera no service app a imagem builda colocar mesmo nome usado no build `felipe/cadastropessoa`

depois exeutar `docker-compose up -d`

abrir swagger em locahost:8082/swagger-ui/index.html
