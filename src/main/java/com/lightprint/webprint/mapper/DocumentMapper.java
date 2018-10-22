package com.lightprint.webprint.mapper;

import com.lightprint.webprint.pojo.Document;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//private int id;
//private String qqNumber;
//private int paperSize;
//private int color;
//private int twoSided;
//private int bind;
//private String comment;

public interface DocumentMapper {

    @Insert("insert into document(qq_number,paper_size,color,two_sided,bind,dcomment,finished,print_date) values(#{qqNumber},#{paperSize},#{color},#{twoSided},#{bind},#{dcomment},#{finished},NOW())")
    public int addDocument(Document document);


    /**
     * 查询所有文档打印任务
     * @return
     */
    @Select("select * from document")
    public List<Document> queryDocumentsSchedules();
}
