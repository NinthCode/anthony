package com.paouke.practice.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by admin on 2017/7/29.
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    /**
     * 添加自定义的静态资源映射
     这里使用代码的方式自定义目录映射，并不影响Spring Boot的默认映射，可以同时使用。
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
