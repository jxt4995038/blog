package com.jxt.entity;

import javax.persistence.*;

@Table(name = "blog_type")
public class BlogType {
    @Id
    private Integer id;

    private String type;

    /**
     * 所属类型id
     */
    private Integer belone;

    /**
     * 一级目录还是二级目录还是三级目录
     */
    private Integer level;

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
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取所属类型id
     *
     * @return belone - 所属类型id
     */
    public Integer getBelone() {
        return belone;
    }

    /**
     * 设置所属类型id
     *
     * @param belone 所属类型id
     */
    public void setBelone(Integer belone) {
        this.belone = belone;
    }

    /**
     * 获取一级目录还是二级目录还是三级目录
     *
     * @return level - 一级目录还是二级目录还是三级目录
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置一级目录还是二级目录还是三级目录
     *
     * @param level 一级目录还是二级目录还是三级目录
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}