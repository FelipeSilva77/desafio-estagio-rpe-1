package br.rpe.cadastropessoa.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("localhost:8080");
        devServer.setDescription("Server URL in Development environment");

        final var componets = new Components()
                .addSecuritySchemes(
                        "apiKey",
                        new SecurityScheme()
                                .scheme("bearer")
                                .type(SecurityScheme.Type.HTTP)
                                .bearerFormat("JWT")
                                .name("api")
                );
        return new OpenAPI().components(componets);
    }
}