package dev.aniketkadam.tfa.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "aniket205kadam",
                        email = "aniketrkadam205@gmail.com",
                        url = "https://aniketkadam.dev"
                ),
                description = "OpenApi documentation for Spring Security",
                title = "Learn OpenApi specification",
                version = "0.1",
                license = @License(
                        name = "License Name",
                        url = "https://license-url.com"
                ),
                termsOfService = "Terms of Service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
                // here we mention the server information
                @Server(
                        description = "PROD ENV",
                        url = "http://website.com"
                )
        },
        security = {
                @SecurityRequirement(
                        // this for all the end-point
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

}
