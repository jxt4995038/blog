package com.jxt.controller;

import com.jxt.controller.response.FailResponse;
import com.jxt.controller.response.IResponse;
import com.jxt.controller.response.SuccessResponse;
import com.jxt.entity.Blog;
import com.jxt.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/14 0014.
 */
@RestController
@RequestMapping(value = "/blog")
public class BlogController {


    @Autowired
    private BlogService blogService;

    @RequestMapping("/blogAdd")
    public IResponse blogAdd(String data_html,String data_text, String blogTitle, int createUserId, Integer blogType, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            blogService.addBlog(data_html,data_text,blogTitle,createUserId,blogType);
            return new SuccessResponse();
        }catch (Exception e){
            e.printStackTrace();
            return new FailResponse(e.getMessage());
        }
    }


    @RequestMapping(value = "/showBlogById",method = RequestMethod.POST)
    public IResponse showBlogById(Integer id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        Blog blog = blogService.showBlogById(id);
        return new SuccessResponse(blog);
    }

    @RequestMapping(value = "/showBlogs",method = RequestMethod.POST)
    public IResponse showBlogs(String blogTypeIds,Integer pageIndex,Integer pageSize,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Map<String,Object>> result = blogService.showBlogs(blogTypeIds,pageIndex,pageSize);
        return new SuccessResponse(result);
    }

}
