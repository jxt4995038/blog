package com.jxt.service;

import java.util.List;
import java.util.Map;

public interface BlogTypeService {

    Map<String,String> showAllTypes() throws Exception;

    Map<String,String> showAllTypesWithoutMapping();
}
