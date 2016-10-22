package cn.zmlio.tinycms.service.impl;

import cn.zmlio.tinycms.service.InitService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZML on 2016/9/26.
 */
@Service
@Slf4j
public class InitServiceImpl implements InitService {
    @Override
    public List<String> collectMappedUrls() {
        ApplicationContext context = ApplicationContextHelper.getApplicationContext();
        //所有的controller
        String[] controllerBeans = context.getBeanNamesForAnnotation(Controller.class);
        //所有的restController
        String[] restControllers = context.getBeanNamesForAnnotation(RestController.class);

        for (String beanName : ArrayUtils.addAll(controllerBeans,restControllers)) {
            Class clazz = context.getBean(beanName).getClass();
            RequestMapping mapping = context.getBean(beanName).getClass().getAnnotation(RequestMapping.class);
            String[] rootPaths = ArrayUtils.addAll(mapping.path(), mapping.value());
            String rootPath = rootPaths.length > 0 ? rootPaths[0] : null;
            Method[] methods = context.getBean(beanName).getClass().getDeclaredMethods();

            for (Method method : methods) {//遍历所有
                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                //该controller下的路径
                String[] subPaths = ArrayUtils.addAll(requestMapping.path(), requestMapping.value());
                log.info(rootPath,subPaths);
            }
        }
        return null;
    }
}
