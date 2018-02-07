package com.jxt.controller;

import com.jxt.controller.response.FailResponse;
import com.jxt.controller.response.IResponse;
import com.jxt.controller.response.SuccessResponse;
import com.jxt.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/blogType")
public class BlogTypeController {
    @Autowired
    private BlogTypeService blogTypeService;

    @RequestMapping(value = "/showAllTypes",method = RequestMethod.POST)
    public IResponse showAllTypes(HttpServletRequest request){
        try {
            Map<String,Object> resultMap;
            HttpSession session = request.getSession();
             resultMap = (Map<String,Object>)session.getAttribute("blogType");
            if (resultMap==null) {
                resultMap =  blogTypeService.showAllTypes();
            }
            return new SuccessResponse(resultMap);
        }catch (Exception e){
            return new FailResponse(e.getMessage());
        }
    }

}
