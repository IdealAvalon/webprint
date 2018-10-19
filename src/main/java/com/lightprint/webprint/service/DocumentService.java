package com.lightprint.webprint.service;

import com.lightprint.webprint.mapper.DocumentMapper;
import com.lightprint.webprint.pojo.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private DocumentMapper documentMapper;

    public int addDocument(Document document){
        return documentMapper.addDocument(document);
    }
}
