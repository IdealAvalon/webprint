package com.lightprint.webprint.component;

import com.lightprint.webprint.pojo.User;
import com.lightprint.webprint.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zhangdq
 * @Description: 自动登录拦截器，用于测试时使用
 * @Date: Create in 19:31 2018/6/13
 */

public class UserAutoLoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(UserAutoLoginInterceptor.class);

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = userService.getUserById(1);
        if(user!=null){
            logger.debug("自动登录：" + user.getUsername());
            request.getSession().setAttribute("user",user);
            return true;
        }
        return true;
    }

}
