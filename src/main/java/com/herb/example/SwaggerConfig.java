package com.herb.example;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
//@ComponentScan("com.herb.example.api.rest")

/*@ComponentScan(basePackageClasses = {
        PetController.class,
        HomeController.class,
        FileUploadController.class
}*/
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("hotels") /*api 组*/
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.herb.example.api.rest"))
                .paths(PathSelectors.any())
//                .paths(petstorePaths())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Aurora API")
                .description("各业务模块api单独目录")
                .termsOfServiceUrl("http。。。")
                .contact("mabin@zjrealtech.com")
                .version("1.0")
                .build();
    }

    private Predicate<String> petstorePaths() {
        return or(
                regex("/api/pet.*"),
                regex("/api/user.*"),
                regex("/api/store.*")
        );
    }

    private Predicate<String> userOnlyEndpoints() {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.contains("user");
            }
        };
    }


    /*认证相关*/

}
