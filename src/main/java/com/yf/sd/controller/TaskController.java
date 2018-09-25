package com.yf.sd.controller;

import com.alibaba.fastjson.JSONObject;
import com.yf.sd.pojo.Task;
import com.yf.sd.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/user/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping("newTask")
    @ResponseBody
    public JSONObject newTask(Task task) throws UnsupportedEncodingException {
        System.out.println(task);
        Cookie[] cookies = request.getCookies();
        String username = URLDecoder.decode(cookies[1].getValue(),"utf-8");
        task.setMaster(username);
        int result = taskService.newTask(task);
        JSONObject json = new JSONObject();
        if(result == 1){
            json.put("state","1");
            json.put("msg","添加成功");
        }else{
            json.put("state","2");
            json.put("msg","添加失败");
        }
        return json;
    }
}
