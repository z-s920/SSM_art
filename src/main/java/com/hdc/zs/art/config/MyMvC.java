package com.hdc.zs.art.config;

import com.hdc.zs.art.component.MyLocaleResolver;
import com.hdc.zs.art.util.UploadUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class MyMvC implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
            }
        };
        return adapter;
    }
    @Bean
    public LocaleResolver localeResolver()
    {
        return new MyLocaleResolver();
    }

    // 用于解决springboot上传图片后，无法直接访问
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/asserts/image/**").addResourceLocations("file:" + UploadUtils.getImgDirFile().getAbsolutePath() + "/");  //添加这一行
    }
}
