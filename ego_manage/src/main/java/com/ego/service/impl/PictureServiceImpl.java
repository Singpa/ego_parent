package com.ego.service.impl;

import com.ego.commons.pojo.EgoResult;
import com.ego.commons.utils.FastDFSClient;
import com.ego.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService {
    @Value("${ego.nginx.host}")
    private String nginxHost;

    @Override
    public Map<String, Object> uploadPicture(MultipartFile multipartFile) {
        Map<String, Object> result = new HashMap<>();
        try {
            InputStream fileBuff = multipartFile.getInputStream();
            String filename = multipartFile.getOriginalFilename();
            String[] strings = FastDFSClient.uploadFile(fileBuff, filename);
            String groupName = strings[0];
            String picLoadName = strings[1];
            String url = nginxHost + groupName + "/" + picLoadName;
            System.out.println("url = " + url);
            result.put("error",0);
            result.put("url", url);
            System.out.println("url = " + url);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            result.put("error",1);
            result.put("message","图片上传失败");
        }
        return result;
    }
}
