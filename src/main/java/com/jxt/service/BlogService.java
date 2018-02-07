package com.jxt.service;

import com.jxt.entity.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {

    //添加一篇博客
    void addBlog(String data_html,String data_text,String blogTitle,int createUserId,Integer blogType);

    //根据id查询博客内容
    Blog showBlogById(Integer id);

    //分页查询博客内容
    List<Map<String,Object>> showBlogs(String blogTypeIds, Integer pageIndex, Integer pageSize);

}
