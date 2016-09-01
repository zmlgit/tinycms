package cn.zmlio.tinycms.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ZML on 2016/9/1.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "cn.zmlio.tinycms")
public class App {
    public static void main(String...args){
        SpringApplication.run(App.class,args);
    }
}
