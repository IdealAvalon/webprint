package com.lightprint.webprint.config;

import com.lightprint.webprint.component.AccessInterceptor;
import com.lightprint.webprint.component.UserAutoLoginInterceptor;
import com.lightprint.webprint.utils.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 18:40 2018/6/10
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //设置视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 门户首页
        registry.addViewController("/").setViewName("portal/index");
        registry.addViewController("/index").setViewName("portal/index");
        // 登录页
        registry.addViewController("/userLogin").setViewName("sign_in");
        registry.addViewController("/sign").setViewName("sign_in");
        // 用户打印页
        registry.addViewController("/document_print").setViewName("user_print/document_print");
        registry.addViewController("/success").setViewName("user_print/success");
        // 管理员查看订单页
        registry.addViewController("/document_print_orders").setViewName("manage/document_print_orders");
//        registry.addViewController("/documentPrintOrders").setViewName("manage/document_print_orders");
    }

    /**
     * 日期类型转换器
     */
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @PostConstruct //spring容器初始化的时候执行该方法
    public void initEditableValidation(){
        ConfigurableWebBindingInitializer initializer=(ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        if (initializer.getConversionService()!=null){
            GenericConversionService genericConversionService=(GenericConversionService) initializer.getConversionService();
            genericConversionService.addConverter(new StringToDateConverter());
        }
    }

    /**
     * 自定义权限过滤
     */
    @Bean
    public AccessInterceptor accessInterceptor(){
        return new AccessInterceptor();
    }

    /**
     * 自定义自动登录拦截器，用于测试
     * @return
     */
    @Bean
    public UserAutoLoginInterceptor userAutoLoginInterceptor(){
        return new UserAutoLoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(userAutoLoginInterceptor()).addPathPatterns("/").excludePathPatterns("/sign");
        registry.addInterceptor(accessInterceptor()).addPathPatterns("/**").excludePathPatterns("/sign","/document_print","/documentPrint","/index","/user/**");
    }


}
