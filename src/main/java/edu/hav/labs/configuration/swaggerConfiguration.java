package edu.hav.labs.configuration;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  swaggerConfiguration
  @version  1.0.0 
  @since 23.04.2021
*/

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swaggerConfiguration {

    public OpenAPI customOpenAPI() {

        return new OpenAPI().
                info(
                        new Info()
                                .title("Курсова")
                                .version("1.0")
                                .contact(
                                        new Contact()
                                                .email("my-email@gmail.com")
                                                .name("My Namwe")
                                                .url("my-site.cv.ua")
                                )
                );
    }
}
