package com.lightprint.webprint.service;

import com.lightprint.webprint.mapper.PhotoMapper;
import com.lightprint.webprint.pojo.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 16:21 2018/10/22
 */
@Service
public class PhotoService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private PhotoMapper photoMapper;

    public int addPhotoSchedule(Photo photo){
        return photoMapper.addPhotoSchedule(photo);
    }

    public List<Photo> getPhotoSchedules() {
        return photoMapper.getPhotoSchedules();
    }

    public int finishPhotoOrder(Integer id) {
        return photoMapper.finishPhotoOrder(id);
    }
}
