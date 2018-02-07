package com.jxt.controller;

import com.jxt.controller.response.IResponse;
import com.jxt.controller.response.SuccessResponse;
import com.jxt.entity.BlogReply;
import com.jxt.service.BlogReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogReply")
public class BlogReplyController {

    @Autowired
    private BlogReplyService blogReplyService;

    @RequestMapping(value = "/addReply",method = RequestMethod.POST)
    public IResponse addReply(Integer userId,Integer blogId,String data_html){

        blogReplyService.addReply(userId,blogId,data_html);
        return new SuccessResponse();
    }

    @RequestMapping(value = "/showReplyByBlogId",method = RequestMethod.POST)
    public IResponse showReplyByBlogId(Integer blogId){
        List<BlogReply> blogReplies = blogReplyService.showReplyByBlogId(blogId);

        return new SuccessResponse(blogReplies);
    }
}
