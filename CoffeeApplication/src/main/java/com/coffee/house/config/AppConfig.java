/**
 * 
 */
package com.coffee.house.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dinesh
 *
 */
@Configuration
@ComponentScan(basePackages= {"com.coffee.house"})
@EnableSwagger2
public class AppConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/CoffeeHouse.*"), regex("/CoffeeHouse/Customer.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Coffee Application")
				.description("CoffeeHouse Application API reference").version("1.0").build();
	}
}
