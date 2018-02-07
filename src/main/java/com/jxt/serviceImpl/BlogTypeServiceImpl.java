package com.jxt.serviceImpl;

import com.jxt.dao.BlogTypeMapper;
import com.jxt.entity.BlogType;
import com.jxt.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BlogTypeServiceImpl implements BlogTypeService{
    @Autowired
    private BlogTypeMapper blogTypeMapper;

    @Override
    public Map<String,Object> showAllTypes() throws Exception {
        Map<String,Object> resultMap = new HashMap<>();

        Example example = new Example(BlogType.class);
        example.createCriteria().andEqualTo("level",1);
        List<BlogType> blogTypes = blogTypeMapper.selectByExample(example);
        if (blogTypes!=null&&blogTypes.size()==0) {
            throw new Exception("数据库中没有博客分类信息");
        }
        for (BlogType blogType : blogTypes) {
            example.clear();
            example.createCriteria().andEqualTo("level",2).andEqualTo("belone",blogType.getId());
            List<BlogType> subTypes = blogTypeMapper.selectByExample(example);
            if (subTypes==null||subTypes.size()==0) {
                //没有二级菜单的话  map中放入的内容 key=类型id，类型名称  value=null
                resultMap.put(String.valueOf(blogType.getId()+","+blogType.getType()),null);
            }else {
                //有二级菜单的话  map中放入的内容  key为 子类型id1+子类型id2+子类型id3，父类型名字 value数据类型为List<Map> 子类型的id  子类型的name
                String key_first = String.join("-",subTypes.stream().map(e ->String.valueOf(e.getId())).collect(Collectors.toList()));

                BlogType parentType = blogTypeMapper.selectByPrimaryKey(blogType.getId());
                String key_last = parentType.getType();
                String key = key_first+","+key_last;

                List<Map<String,String>> innerList = new ArrayList<>();
                for (BlogType subType : subTypes) {
                    Map<String,String> innerMap = new HashMap<>();
                    innerMap.put(String.valueOf(subType.getId()),subType.getType());
                    innerList.add(innerMap);
                }
                resultMap.put(key,innerList);
            }
        }
        return resultMap;
    }

}

