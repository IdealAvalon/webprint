package com.lightprint.webprint.controller;

import com.lightprint.webprint.pojo.Document;
import com.lightprint.webprint.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 18:47 2018/10/19
 */
@Controller
public class PrintController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("documentPrint")
    public String userPrint(Document document){


        return "submitSuccess";
    }

}
