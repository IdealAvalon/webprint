package com.lightprint.webprint.controller;

import com.lightprint.webprint.pojo.Document;
import com.lightprint.webprint.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 18:47 2018/10/19
 */
@Controller
public class PrintController {

    @Autowired
    private DocumentService documentService;

    /**
     * 用户添加打印任务
     * @param document
     * @return
     */
    @PostMapping("documentPrint")
    public String userPrint(Document document){
        documentService.addDocument(document);
        return "user_print/success";
    }

    /**
     * 管理员查询文档打印
     */
    @GetMapping("queryDocuments")
    @ResponseBody
    public List<Document> queryDocument(){
        return documentService.getDocumentSchedules();
    }

    @RequestMapping("all_print_orders")
    public String toAllPrintOrders(Model model){
        List<Document> documentSchedules = documentService.getDocumentSchedules();
        model.addAttribute("documents",documentSchedules);
        return "manage/all_print_orders";
    }
}
