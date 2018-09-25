package com.yf.sd.filter;

import com.alibaba.fastjson.JSONObject;
import com.yf.sd.util.TokenStart;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class filter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse resp, Object o) throws Exception {
        Cookie[] cookies = request.getCookies();
//        System.out.println(cookies[0].getName()+","+cookies[0].getValue());
//        System.out.println(cookies[1].getName()+","+cookies[1].getValue());
        int result = TokenStart.ValidToken(cookies[0].getValue());
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        if(result == 0){
            PrintWriter writer = resp.getWriter();
            cookies[0].setValue(null);
            cookies[0].setMaxAge(0);
            JSONObject json = new JSONObject();
            json.put("msg","登录失效，请重新登录！");
            json.put("state","0");
            writer.write(String.valueOf(json));
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
