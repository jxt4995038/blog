package com.jxt.serviceImpl;

import com.jxt.dao.TestMapper;
import com.jxt.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Map> test = testMapper.test();
        String name = test.get(0).get("name").toString();
        return name;
    }


    public void connectMysql(){
        testMapper.connectMysql();
    }
}
