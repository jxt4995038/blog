package com.jxt.serviceImpl;

import com.jxt.dao.BlogTypeMapper;
import com.jxt.entity.BlogType;
import com.jxt.service.BlogTypeService;
import com.jxt.util.Jsons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BlogTypeServiceImpl implements BlogTypeService{
    private static final Logger logger = LoggerFactory.getLogger(BlogTypeServiceImpl.class);

    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private BlogTypeMapper blogTypeMapper;

    //带有主从关系的博客类型关  如果下面没有子分类，则key为类型id，value为类型名字，如果有子分类，
    public static Map<String,Object> blogTypeMapWithLevel = new HashMap<>();

    //没有带主从关系的博客类型  key为类型id  value为类型名字  再反转一下
    public static Map<String,String> blogTypeMap = new HashMap<>();


    public void initBolgType(){
        List<BlogType> blogTypes = blogTypeMapper.selectAllType();
        for (BlogType blogType : blogTypes) {
            blogTypeMap.put(String.valueOf(blogType.getId()),blogType.getType());
            blogTypeMap.put(blogType.getType(),String.valueOf(blogType.getId()));
        }
        logger.info("init blog type without level mapping");
    }

    public Map<String,String> showAllTypes() throws Exception{
        Jedis jedis = jedisPool.getResource();
        Map<String, String> blogTypeMapWithLevel;
        blogTypeMapWithLevel= jedis.hgetAll("blogTypeMapWithLevel");
        if (blogTypeMapWithLevel==null||blogTypeMapWithLevel.isEmpty()) {
            List<BlogType> blogTypes = blogTypeMapper.selectParentType();
            if (blogTypes!=null&&blogTypes.size()==0) {
                throw new Exception("数据库中没有博客分类信息");
            }
            for (BlogType blogType : blogTypes) {
                Integer parentId = blogType.getId();
                List<BlogType> subTypes = blogTypeMapper.selectChildType(parentId);
                if (subTypes==null||subTypes.size()==0) {
                    //没有二级菜单的话  map中放入的内容 key=类型id，类型名称  value=null
                    jedis.hset("blogTypeMapWithLevel",String.valueOf(blogType.getId()+","+blogType.getType()),"");
                }else {
                    //有二级菜单的话  map中放入的内容  key为 子类型id1+子类型id2+子类型id3，父类型名字 value数据类型为List<Map> 子类型的id  子类型的name
                    String key_first = String.join("-",subTypes.stream().map(e ->String.valueOf(e.getId())).collect(Collectors.toList()));

                    BlogType parentType = blogTypeMapper.selectById(blogType.getId());
                    String key_last = parentType.getType();
                    String key = key_first+","+key_last;

                    List<Map<String,String>> innerList = new ArrayList<>();
                    for (BlogType subType : subTypes) {
                        Map<String,String> innerMap = new HashMap<>();
                        innerMap.put(String.valueOf(subType.getId()),subType.getType());
                        innerList.add(innerMap);
                    }
                    jedis.hset("blogTypeMapWithLevel",key,Jsons.objToJson(innerList));
                }
            }
            blogTypeMapWithLevel= jedis.hgetAll("blogTypeMapWithLevel");
        }else {
            blogTypeMapWithLevel= jedis.hgetAll("blogTypeMapWithLevel");
        }
        return blogTypeMapWithLevel;
    }

}

