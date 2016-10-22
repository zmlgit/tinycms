package cn.zmlio.tinycms.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by ZML on 2016/9/26.
 */
@Slf4j
@Component
public class ApplicationContextHelper implements ApplicationContextAware {

    private static volatile ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHelper.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            log.error("applicationContext has not injected yet!");
        }
        return applicationContext;
    }
}
