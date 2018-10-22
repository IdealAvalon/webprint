package com.lightprint.webprint.controller;

import com.lightprint.webprint.pojo.Document;
import com.lightprint.webprint.pojo.Manager;
import com.lightprint.webprint.pojo.User;
import com.lightprint.webprint.service.DocumentService;
import com.lightprint.webprint.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 21:22 2018/6/10
 */
@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private DocumentService documentService;

    /**
     * 用户登录
     * @param manager
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/user/login")
    public String userLogin(Manager manager, Model model, HttpSession session, HttpServletRequest request){
        Manager queryUser = userService.getUserByUsernameAndPassword(manager);
        String msg;
        if(queryUser!=null&&manager!=null&&queryUser.getPassword().equals(manager.getPassword())) {
            model.addAttribute("user",queryUser);
            session.setAttribute("user",queryUser);
            request.getSession().setAttribute("user",queryUser);
            System.out.println(session.getAttribute("user"));
            if(1 == queryUser.getRole()){
//                List<Document> documentSchedules = documentService.getDocumentSchedules();
//                model.addAttribute("documents",documentSchedules);
//                return "manage/document_print_orders";
                return "redirect:/documentPrintOrders";
            }else {
                return "redirect:/index";
            }
        }
        msg="登录失败~";
        model.addAttribute("msg", msg);
        return "sign_in";
    }

    /**
     * 用户注销
     * @param request
     * @return
     */
    @RequestMapping("/user/logout")
    public String userLogout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/sign";
    }

//    @RequestMapping("/managePage")
//    public String toManagePage(Model model){
//        List<Document> documentSchedules = documentService.getDocumentSchedules();
//        model.addAttribute("documents",documentSchedules);
//        return "manage/all_print_orders";
//    }
}
