package com.lightprint.webprint.mapper;

import com.lightprint.webprint.pojo.Photo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 16:23 2018/10/22
 */
public interface PhotoMapper {

    @Insert("insert into photo(qq_number,paper_size,color,dcomment,finished,print_date) values(#{qqNumber},#{paperSize},#{color},#{dcomment},#{finished},NOW())")
    public int addPhotoSchedule(Photo photo);

    @Select("select * from photo where finished = 0")
    public List<Photo> getPhotoSchedules();

    @Update("update photo set finished = 1 where id = #{id}")
    public int finishPhotoOrder(Integer id);
}
