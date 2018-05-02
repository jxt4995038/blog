package com.jxt.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "blog")
public class Blog {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 博客标题
     */
    @Size(min = 3,message = "标题太短，请重新输入")
    private String title;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 博客状态 1：正常 0 删除
     */
    private Integer status;

    /**
     * 博文类型id
     */
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 博客内容(带html格式)
     */
    @Column(name = "content_html")
    private String contentHtml;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取博客标题
     *
     * @return title - 博客标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置博客标题
     *
     * @param title 博客标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取博客状态 1：正常 0 删除
     *
     * @return status - 博客状态 1：正常 0 删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置博客状态 1：正常 0 删除
     *
     * @param status 博客状态 1：正常 0 删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取博文类型id
     *
     * @return type_id - 博文类型id
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 设置博文类型id
     *
     * @param typeId 博文类型id
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * @return create_user_id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * @param createUserId
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取博客内容(带html格式)
     *
     * @return content_html - 博客内容(带html格式)
     */
    public String getContentHtml() {
        return contentHtml;
    }

    /**
     * 设置博客内容(带html格式)
     *
     * @param contentHtml 博客内容(带html格式)
     */
    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }
}