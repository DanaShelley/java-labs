package edu.hav.labs.configuration;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  SwaggerConfiguration
  @version  1.0.0 
  @since 17.05.2021
*/

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info().title("Бібліотечний фонд - лабораторні роботи")
                                            .version("1.0")
                                            .description("2 курс, 2 семестр")
                                            .license(new License().name("Apache 2.0")
                                                                  .url("http://springdoc.org"))
                                            .contact(new Contact().name("Гавалешко Богдана")
                                                                  .email("gavaleskobogdana@gmail.com")));
    }
}
