package com.jxt.serviceImpl;

import com.jxt.dao.BlogMapper;
import com.jxt.entity.Blog;
import com.jxt.eum.BlogStatus;
import com.jxt.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {


    @Autowired
    private BlogMapper blogMapper;

    @Override
    public void addBlog(String data_html,String data_text,String blogTitle,int createUserId,Integer blogType) {
        //1、将博客的内容存在data/blogContent目录下，文件名为20170101_1_9999来存    下划线后的1为userId   9999为随机数
//        String path = blogContentPath;
//        File derectory = new File(blogContentPath);
//        if (!derectory.exists()) {
//            derectory.mkdirs();
//        }
//        String date = LocalDate.now().toString().replaceAll("-","");
//        int random = (int) (Math.random() * 10000);
//        String index  = String.format("%04d",random);
//        String fileName = date+"_"+createUserId+"_"+index+".txt";
//        System.out.println(blogContentPath + fileName);
//        File file = new File(blogContentPath+fileName);
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            OutputStream os = new FileOutputStream(file);
//            os.write(data.getBytes());
//            os.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
            //2 将blog信息插入数据库中
            Blog blog = new Blog();
            blog.setTitle(blogTitle);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            blog.setCreateTime(sdf.format(new Date()));
            blog.setContentHtml(data_html);
            blog.setTypeId(blogType);
            blog.setStatus(BlogStatus.VALID.getIndex());
            blog.setCreateUserId(createUserId);
            blogMapper.insert(blog);

    }

    @Override
    public Blog showBlogById(Integer id){
        Blog blog = blogMapper.selectByPrimaryKey(id);
        return blog;
    }

    @Override
    public List<Map<String,Object>> showBlogs(String blogTypeIds,Integer pageIndex,Integer pageSize) {
        Example example = new Example(Blog.class);
        if (blogTypeIds!=null&&!"".equals(blogTypeIds)){
            List<String> idList = Arrays.asList(blogTypeIds.split("-"));
            example.createCriteria().andIn("typeId",idList);
        }
        example.setOrderByClause("id desc");

//        PageHelper.startPage(pageIndex,pageSize);
        List<Blog> blogList = blogMapper.selectByExample(example);

        List<Map<String,Object>> resultMapList = new ArrayList<>();
        for (Blog blog : blogList) {
            Map<String,Object> innerMap = new HashMap<>();
            innerMap.put("id",blog.getId());
            innerMap.put("title",blog.getTitle());
            innerMap.put("createTime",blog.getCreateTime());
            innerMap.put("contentHtml",blog.getContentHtml());
            innerMap.put("typeName", BlogTypeServiceImpl.blogTypeMap.get(String.valueOf(blog.getTypeId())));
            resultMapList.add(innerMap);
        }
        return resultMapList;
    }

}
