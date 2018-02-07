package com.jxt.service;

import com.jxt.entity.BlogReply;

import java.util.List;

public interface BlogReplyService {

    void addReply(Integer userId,Integer blogId,String content_html);

    List<BlogReply> showReplyByBlogId(Integer blogId);
}
