package cn.zmlio.tinycms.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ZML on 2016/10/16.
 */
@Controller
@RequestMapping("/admin/init")
public class InitController {
    @RequestMapping(value = {"", "/"})
    public ModelAndView init(HttpServletRequest request) {
        ServletContext servletContext = request.getSession().getServletContext();
        if (servletContext == null) {
            return null;
        }
        WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        //请求url和处理方法的映射
        List<RequestToMethodItem> requestToMethodItemList = new ArrayList<RequestToMethodItem>();
        //获取所有的RequestMapping
        Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(appContext,

                HandlerMapping.class, true, false);

        for (HandlerMapping handlerMapping : allRequestMappings.values()) {
            //本项目只需要RequestMappingHandlerMapping中的URL映射
            if (handlerMapping instanceof RequestMappingHandlerMapping) {
                RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) handlerMapping;
                Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
                for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet()) {
                    RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
                    HandlerMethod mappingInfoValue = requestMappingInfoHandlerMethodEntry.getValue();

                    RequestMethodsRequestCondition methodCondition = requestMappingInfo.getMethodsCondition();
                    String requestType = methodCondition.getMethods().size() < 1 ? "GET" : ((RequestMethod) methodCondition.getMethods().toArray()[0]).name();
                    PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
                    String requestUrl = (String) patternsCondition.getPatterns().toArray()[0];
                    String controllerName = mappingInfoValue.getBeanType().toString();
                    String requestMethodName = mappingInfoValue.getMethod().getName();
                    Class<?>[] methodParamTypes = mappingInfoValue.getMethod().getParameterTypes();
                    RequestToMethodItem item = new RequestToMethodItem(requestUrl, requestType, controllerName, requestMethodName,
                            methodParamTypes);
                    requestToMethodItemList.add(item);
                }
                //break;
            }
        }
        return new ModelAndView("index").addObject("MethodList", requestToMethodItemList);
    }

    private class RequestToMethodItem {
        public String controllerName;
        public String methodName;
        public String requestType;
        public String requestUrl;
        public Class<?>[] methodParmaTypes;

        public RequestToMethodItem(String requestUrl, String requestType, String controllerName, String requestMethodName,

                                   Class<?>[] methodParmaTypes) {
            this.requestUrl = requestUrl;
            this.requestType = requestType;
            this.controllerName = controllerName;
            this.methodName = requestMethodName;
            this.methodParmaTypes = methodParmaTypes;

        }
    }

}
