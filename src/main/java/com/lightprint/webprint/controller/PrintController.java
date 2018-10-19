package com.lightprint.webprint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 18:47 2018/10/19
 */
@Controller
public class PrintController {

    @PostMapping("documentPrint")
    public String userPrint(){

        return "submitSuccess";
    }

}
