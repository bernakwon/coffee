package com.dream.coffee.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
        title = "Coffee Order API 명세서",
        description = "API 명세서",
        version = "v1",
        contact = @Contact(
            name = "Hyeran Kwon",
            email = "hrkwon316@gmail.com"
        )
    )
)

@Configuration
public class OpenApiConfig {

}