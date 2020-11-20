package com.ego.service;

import com.ego.commons.pojo.EgoResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PictureService {
    Map<String, Object> uploadPicture(MultipartFile multipartFile);
}
