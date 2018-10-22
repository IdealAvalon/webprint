package com.lightprint.webprint.component;

import com.lightprint.webprint.pojo.User;
import com.lightprint.webprint.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zhangdq
 * @Description: 自动登录拦截器，用于测试时使用
 * @Date: Create in 19:31 2018/6/13
 */

public class AccessInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(AccessInterceptor.class);

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if(null == user){
            response.sendRedirect("/index");
            return false;
        }else{
            return true;
        }
    }

}
