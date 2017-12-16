package com.jxt.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.jxt.dao.TestMapper;
import com.jxt.entity.Test;
import com.jxt.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    public Test test(Integer id) throws Exception{
        Example example = new Example(Test.class);
        example.createCriteria().andEqualTo("id",id);

        List<Test> tests = testMapper.selectByExample(example);
        if (tests==null||tests.size()==0) {
            throw new Exception("没有查询到该博文");
        }
        return tests.get(0);
    }


    public void connectMysql(){
        testMapper.connectMysql();
    }
}
