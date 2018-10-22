package com.lightprint.webprint.controller;

import com.lightprint.webprint.pojo.Document;
import com.lightprint.webprint.pojo.Photo;
import com.lightprint.webprint.service.DocumentService;
import com.lightprint.webprint.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private PhotoService photoService;

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
     * 管理员查询文档打印（这个准备做js的）
     */
    @GetMapping("queryDocuments")
    @ResponseBody
    public List<Document> queryDocument(){
        return documentService.getDocumentSchedules();
    }

    /**
     * 管理员查询文档打印订单
     * @param model
     * @return
     */
    @RequestMapping("/documentPrintOrders")
    public String toAllPrintOrders(Model model){
        List<Document> documentSchedules = documentService.getDocumentSchedules();
        model.addAttribute("documents",documentSchedules);
        return "manage/document_print_orders";
    }

    /**
     * 管理员操作完成打印订单
     */
    @GetMapping("documentPrint/{id}")
    public String doPrintOrder(@PathVariable("id") Integer id){
        documentService.finishDocumentPrintOrder(id);
        return "redirect:/documentPrintOrders";
    }

    /**
     * 用户添加照片打印订单
     */
    @PostMapping("photoPrint")
    public String addUserPhotoPrint(Photo photo){
        photoService.addPhotoSchedule(photo);
        return "user_print/success";
    }

    /**
     * 管理员查看照片打印订单
     */
    @GetMapping("photoPrintOrders")
    public String toPhotoPrintOrders(Model model){
        List<Photo> photoList = photoService.getPhotoSchedules();
        model.addAttribute("photos",photoList);
        return "manage/photo_print_orders";

    }
    /**
     * 管理员操作完成打印照片订单
     */
    @GetMapping("photoPrint/{id}")
    public String doPrintPhotoOrder(@PathVariable("id") Integer id){
        photoService.finishPhotoOrder(id);
        return "redirect:/photoPrintOrders";
    }
}
