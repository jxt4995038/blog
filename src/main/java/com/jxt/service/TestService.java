package com.jxt.service;

import com.jxt.entity.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public interface TestService {

    Test test(Integer id) throws Exception;

    void connectMysql();
}
