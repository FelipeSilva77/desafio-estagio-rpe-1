package br.rpe.cadastropessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CadastroPessoaApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(CadastroPessoaApplication.class, args);
    }
}
