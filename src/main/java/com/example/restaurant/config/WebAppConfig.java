package com.example.restaurant.config;

import com.example.restaurant.util.GetPath;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 10:58
 **/
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

       registry.addResourceHandler("swagger-ui.html")
               .addResourceLocations("classpath:/META-INF/resources/");


       registry.addResourceHandler("/IMG/**").addResourceLocations("file:"+ GetPath.getClassPath()+"images/");
        super.addResourceHandlers(registry);

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 /atguigu 请求来到 success

        registry.addViewController("/").setViewName("index.html");
        super.addViewControllers(registry);
    }
}
