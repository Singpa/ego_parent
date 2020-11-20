package com.ego.controller;

import com.ego.commons.pojo.EgoResult;
import com.ego.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map<String, Object> picUpload(@RequestParam("uploadFile") MultipartFile uploadFile) {
        return pictureService.uploadPicture(uploadFile);
    }
}
