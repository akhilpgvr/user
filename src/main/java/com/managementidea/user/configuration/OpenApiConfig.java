package com.managementidea.user.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("My Spring Boot API")
                        .description("Sample API for demonstrating OpenAPI integration")
                        .version("v1.0")
                        .contact(new Contact().name("Your Name").email("yourname@example.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}

