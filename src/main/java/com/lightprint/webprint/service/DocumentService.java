package com.lightprint.webprint.service;

import com.lightprint.webprint.mapper.DocumentMapper;
import com.lightprint.webprint.pojo.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired(required = false)
    private DocumentMapper documentMapper;

    public int addDocument(Document document){
        return documentMapper.addDocument(document);
    }

    public List<Document> getDocumentSchedules() {
        return documentMapper.queryDocumentsSchedules();
    }

    public int finishDocumentPrintOrder(Integer id) {
        return documentMapper.finishDocumentPrintOrder(id);
    }

}
