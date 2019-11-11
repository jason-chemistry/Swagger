package com.test.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //标记配置类
@EnableSwagger2
public class swagger {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //指向自己的controller即可
                .apis(RequestHandlerSelectors.basePackage("com.test.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 设置文档信息
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //页面标题
                .title("SpringBoot中使用Swagger2构建RESTful API")
                //描述
                .description("更多资料, 请查看: https://blog.csdn.net/q343509740")
                //设置作者联系方式,可有可无
                .contact("Ray")
                //版本号
                .version("1.0")
                .build();
    }

}
