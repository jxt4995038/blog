package com.jxt.dao;

import com.jxt.MyMapper;
import com.jxt.entity.BlogType;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BlogTypeMapper extends MyMapper<BlogType> {

    @Select("select id,type,belone,level from blog_type where level = 1")
    List<BlogType> selectParentType();
    @Select("select id,type,belone,level from blog_type where level = 2 and belone = #{parentId}")
    List<BlogType> selectChildType(Integer parentId);
    @Select("select id,type,belone,level from blog_type where id = #{id}")
    BlogType selectById(Integer id);
    @Select("select id,type,belone,level from blog_type")
    List<BlogType> selectAllType();
}