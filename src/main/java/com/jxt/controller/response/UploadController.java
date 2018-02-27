package com.jxt.controller.response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController extends HttpServlet{
    @Value("${image.path.blogContent}")
    private String imagePath;


    @RequestMapping("/uploadImg")
    public void uploadImg(HttpServletRequest request, HttpServletResponse response){
        try {
            Part part = request.getPart("yourFileName");

            String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
            boolean allowed = Arrays.asList(allowedType).contains(part.getContentType());
            if (!allowed) {
                response.getWriter().write("error|不支持的类型");
                return;
            }
            // 图片大小限制
            if (part.getSize() > 5 * 1024 * 1024) {
                response.getWriter().write("error|图片大小不能超过5M");
                return;
            }
            // 包含原始文件名的字符串
            String fi = part.getHeader("content-disposition");
            // 提取文件拓展名
            String fileNameExtension = fi.substring(fi.indexOf("."), fi.length() - 1);
            // 生成实际存储的真实文件名
            String realName = UUID.randomUUID().toString() + fileNameExtension;
            // 图片存放的真实路径
            String realPath = getServletContext().getRealPath("/files") + "/" + realName;
            part.write(realPath);

            // 返回图片的URL地址
            response.getWriter().write(request.getContextPath() + "/files/" + realName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
