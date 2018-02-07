package com.jxt.serviceImpl;

import com.jxt.dao.BlogReplyMapper;
import com.jxt.entity.BlogReply;
import com.jxt.service.BlogReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BlogReplyServiceImpl implements BlogReplyService{
    @Autowired
    private BlogReplyMapper blogReplyMapper;

    @Override
    public void addReply(Integer userId, Integer blogId, String content_html) {
        //如果没有userId的话，说明是游客回复的

        BlogReply blogReply = new BlogReply();
        blogReply.setBlogid(blogId);
        blogReply.setContentHtml(content_html);
        blogReply.setAgreeNumber(0);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss");
        blogReply.setTime(sdf.format(new Date()));

        blogReplyMapper.insert(blogReply);
    }

    @Override
    public List<BlogReply> showReplyByBlogId(Integer blogId) {
        Example example = new Example(BlogReply.class);
        example.createCriteria().andEqualTo("blogid",blogId);
        List<BlogReply> blogReplies = blogReplyMapper.selectByExample(example);
        return blogReplies;
    }
}
