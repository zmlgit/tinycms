package cn.zmlio.tinycms;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ZML on 2016/8/29.
 */
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class WebAppStarter extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(WebAppStarter.class);
        return super.configure(builder);
    }
}
