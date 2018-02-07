package com.jxt.entity;

import javax.persistence.*;

@Table(name = "blog_reply")
public class BlogReply {
    @Id
    private Integer id;

    /**
     * 博文id
     */
    private Integer blogid;

    /**
     * 评论者的id
     */
    private Integer userid;

    /**
     * 评论时间
     */
    private String time;

    /**
     * 赞同的人数
     */
    @Column(name = "agree_number")
    private Integer agreeNumber;

    /**
     * 回复内容
     */
    @Column(name = "content_html")
    private String contentHtml;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取博文id
     *
     * @return blogid - 博文id
     */
    public Integer getBlogid() {
        return blogid;
    }

    /**
     * 设置博文id
     *
     * @param blogid 博文id
     */
    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    /**
     * 获取评论者的id
     *
     * @return userid - 评论者的id
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置评论者的id
     *
     * @param userid 评论者的id
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取评论时间
     *
     * @return time - 评论时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置评论时间
     *
     * @param time 评论时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取赞同的人数
     *
     * @return agree_number - 赞同的人数
     */
    public Integer getAgreeNumber() {
        return agreeNumber;
    }

    /**
     * 设置赞同的人数
     *
     * @param agreeNumber 赞同的人数
     */
    public void setAgreeNumber(Integer agreeNumber) {
        this.agreeNumber = agreeNumber;
    }

    /**
     * 获取回复内容
     *
     * @return content_html - 回复内容
     */
    public String getContentHtml() {
        return contentHtml;
    }

    /**
     * 设置回复内容
     *
     * @param contentHtml 回复内容
     */
    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }
}