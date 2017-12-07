package com.jxt.serviceImpl;

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

    public String test(){
        Example example = new Example(Test.class);
        example.createCriteria().andEqualTo("id",1);
        List<Test> tests = testMapper.selectByExample(example);
        String name = tests.get(0).getName();
        return name;
    }


    public void connectMysql(){
        testMapper.connectMysql();
    }
}
