package com.rahioui.youssef.assurance.web;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gestion des Contrats d'Assurance")
                        .version("1.0.0")
                        .description("Application de gestion des contrats d'assurance automobile, habitation et santé")
                        .contact(new Contact()
                                .name("RAHIOUI Youssef")
                                .email("yousset.chan@gmail.com")));
    }
}
