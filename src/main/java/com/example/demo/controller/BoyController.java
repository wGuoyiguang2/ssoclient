package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Boy;
import com.example.demo.mapper.BoyMapper;
import com.majiaxueyuan.sso.core.annotation.NoToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-03-07 13:14
 **/

@RestController
@RequestMapping("/boy")
public class BoyController {



    @Resource
    BoyMapper boyMapper;

    // org.springframework.core.env.Environment
    @Autowired
    Environment environment;




    /**
     * @NoToken 表示不需要 JWT 认证
     */
    @RequestMapping("/hello")
    @NoToken
    public Map<String,String> hello(){
        Map<String,String> result = new HashMap<>();
        result.put("code","0");
        result.put("msg","您好，陌生人");
        return result;
    }

    @RequestMapping("/hello1")
    public Map<String,String> hello1(){
    Map<String,String> result = new HashMap<>();
        result.put("code","0");
        result.put("msg","您好，内部员工");
        return result;
    }



    @RequestMapping("/getBoyList")
    @ResponseBody
    public List<Boy> getBoyList(){
        return  boyMapper.getList();
    }


    @RequestMapping("/getBoyList2")
    @ResponseBody
    public List<Boy> getBoyList2(){
        return  boyMapper.getList2();
    }



    @RequestMapping("/getBoyList3")
    @ResponseBody
    public String  getBoyList3(){
        Map<String,String> para = new HashMap<String,String>();
        para.put("defaultProfiles",environment.getDefaultProfiles().toString()) ;
        para.put("env",environment.getProperty("server.port"));
        return JSON.toJSONString(para);
    }












}
