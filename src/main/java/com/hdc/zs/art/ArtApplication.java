package com.hdc.zs.art;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@MapperScan("com.hdc.zs.art.dao")
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)      // 以下两个表示开启权限认证安全框架
@EnableCaching
public class ArtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtApplication.class, args);
        //允许特殊符号,本例是 | { } 做入参，也可追加其他符号
    /*    System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","/{}");*/
    }

}
