package com.lightprint.webprint.mapper;

import com.lightprint.webprint.pojo.Document;
import org.apache.ibatis.annotations.Insert;

//private int id;
//private String qqNumber;
//private int paperSize;
//private int color;
//private int twoSided;
//private int bind;
//private String comment;

public interface DocumentMapper {

    @Insert("insert into document(qq_number) values()")
    public int addDocument(Document document);
}
