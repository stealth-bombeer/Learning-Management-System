package com.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder()
      .group("public-api")
      .pathsToMatch("/**")
      .build();
  }

  @Bean
  public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
    return openApi -> openApi.info(new Info()
      .title("My API")
      .description("API description")
      .version("v1.0")
      .contact(new Contact()
        .name("Your Name")
        .url("https://example.com")
        .email("your-email@example.com")));
  }
}
