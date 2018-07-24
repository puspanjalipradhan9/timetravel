package com.gamesys.spacetimetravel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gamesys.spacetimetravel"))
                .paths(regex("/timetravel.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Time Travel Application",
                "The application identifies if Time travel is possible for a particular application",
                "1.0",
                "www.dummytermsservices.com",
                new Contact("Puspanjali Pradhan","","puspanjali.pradhan@gmail.com"),
                "Open Source",
                "Open Source",
                new ArrayList<>()
        );
        return apiInfo;
    }
}
