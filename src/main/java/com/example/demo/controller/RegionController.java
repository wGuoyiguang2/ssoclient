package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 14:57
 **/
@Controller
@RequestMapping("/region")
public class RegionController {


    @Autowired
    CacheManager cacheManager;



}
