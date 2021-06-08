package com.lxhdj.web.swagger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Getter
@Setter
@ToString
@EnableSwagger2
@ConfigurationProperties(prefix = "common.swagger")
public class Swagger2Config {

    private String basePackage;
    private boolean enabled = true;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .enable(enabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(enabled ? PathSelectors.any() : PathSelectors.none())
                .build();
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("lxhdj", "http://www.jd.com", "wangguijun1@jd.com");
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格")
                .termsOfServiceUrl("http://www.jd.com")
                .contact(contact)
                .version("1.0.0")
                .build();
    }


}