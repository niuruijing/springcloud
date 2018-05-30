package com.hj.feign.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by niuruijing on 2018/5/30.
 * 接口API
 */
@Configuration
@EnableSwagger2//启用Swagger2
public class Swagger {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
                .apiInfo(apiInfo())
                //用来控制哪些接口暴露给Swagger来展现（除了被@ApiIgnore指定的请求）
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hj.feign.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
     * @return
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("牛瑞静","https://my.oschina.net/niuruijing/blog","850650367@qq.com");
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs 测试")
                .description("测试版本 spring boot RESTful APIs")
                //.termsOfServiceUrl("http://blog.didispace.com/")
                .contact(contact)
                .version("1.0")
                .build();
    }

}
