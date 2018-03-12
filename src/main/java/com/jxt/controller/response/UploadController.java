package com.jxt.controller.response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
@RestController
public class UploadController extends HttpServlet{
    @Value("${image.path.blogContent}")
    private String imagePath;


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Map<String,String> uploadImg(HttpServletRequest request, @RequestParam("myFile") MultipartFile file, HttpServletResponse response){
        Map<String,String> resultMap = new HashMap<>();
        String path = "";
        try {
            File file1 = new File(file.getOriginalFilename());
            System.out.println(System.getProperty("catalina.base"));
            file.transferTo(file1);
            System.out.println(file1.getCanonicalPath());
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("data","/"+path);
        return resultMap;
    }
}
