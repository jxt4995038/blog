package com.jxt.dao;

import com.jxt.MyMapper;
import com.jxt.entity.Test;

public interface TestMapper extends MyMapper<Test> {

    int connectMysql();
}