package com.jxt;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by Administrator on 2017/12/7 0007.
 */
//不能被扫描到
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
