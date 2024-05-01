#Cria imagem a partir da imagem do Java 23
FROM openjdk:23-jdk

#Copia o arquivo .jar do build do maven e renomeia ele para app.jar e coloca dentro do container
COPY target/*.jar app.jar

#Entrypoint, onde o container vai executar a instrução da jvm para executar a aplicação.
CMD ["java", "-jar", "app.jar"]