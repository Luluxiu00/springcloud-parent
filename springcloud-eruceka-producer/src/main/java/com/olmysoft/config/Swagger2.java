package com.olmysoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  
@EnableSwagger2 // 启用Swagger2  
public class Swagger2 {  
  
    @Bean  
    public Docket createRestApi() {// 创建API基本信息  
        return new Docket(DocumentationType.SWAGGER_2)  
                .apiInfo(apiInfo())  
                .select()  
                .apis(RequestHandlerSelectors.basePackage("com.olmysoft"))// 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外  
                .paths(PathSelectors.any())                                                   
                .build();  
    }  
  
    private ApiInfo apiInfo() {// 创建API的基本信息，这些信息会在Swagger UI中进行显示  
        return new ApiInfoBuilder()  
                .title("producer的RESTful APIs")// API 标题  
                .description("此文档供前端人员以及其他微服务开发者使用")// API描述  
                .contact("yanbin@olmysoft.com")// 联系人  
                .version("1.0")// 版本号  
                .build();  
    }  
  
}  