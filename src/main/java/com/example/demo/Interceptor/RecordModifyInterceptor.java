package com.example.demo.Interceptor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-03-07 14:42
 **/
@Slf4j
public class RecordModifyInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取请求参数
        String queryString = request.getQueryString();
        log.info("HandlerInterceptor 接口 请求参数:{}", queryString);

        //获取请求body
        byte[] bodyBytes = StreamUtils.copyToByteArray(request.getInputStream());
        String body = new String(bodyBytes, request.getCharacterEncoding());
        if (!StringUtils.isEmpty(body)){
            log.info("HandlerInterceptor 接口 请求体：{}", body);
            return true;
        }

        //输出响应流
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hmac", "");
        jsonObject.put("status", "");
        jsonObject.put("code", "4007");
        jsonObject.put("msg", "未登录");
        jsonObject.put("data", "");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getOutputStream().write(jsonObject.toJSONString().getBytes("UTF-8"));
         return false ;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerInterceptor 接口 执行了TestInterceptor的postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
