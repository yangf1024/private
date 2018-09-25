package com.yf.sd.controller;


import com.alibaba.fastjson.JSONObject;
import com.yf.sd.util.TokenStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yf.sd.pojo.User;
import com.yf.sd.service.UserService;
import sun.misc.BASE64Decoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	//注册
	@RequestMapping(value="register")
	@ResponseBody
	public Map register(User user){
		HashMap<String, Object> result = new HashMap<>();
		int re = userService.yz_username(user);

        System.out.println(user);
		if(re == 0){
			userService.register(user);
			result.put("state","1");
			result.put("msg","注册成功");
		}else{
			result.put("state","2");
			result.put("msg","用户名重复");
		}
		return result;
	}
	//登录
	@RequestMapping(value="login")
	@ResponseBody
	public Map login(String username, String pwd, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		HashMap<String, Object> map = new HashMap<>();
		System.out.println(username+","+pwd);
		String token = TokenStart.TokenTest(username);
		Cookie token1 = new Cookie("token", token);
        Cookie token2 = new Cookie("user", URLEncoder.encode(username, "utf-8"));
		response.addCookie(token1);
        response.addCookie(token2);
        int result = userService.login(username,pwd);
		System.out.println("登录："+result);
		if(result == 1){
            map.put("state","1");
            map.put("msg","登录成功");
        }else{
            map.put("state","2");
            map.put("msg","登录失败");
        }
		return map;
	}
	//图片上传
	@RequestMapping("upload")
    @ResponseBody
    public JSONObject cs (String imgPath){
		System.out.println(imgPath);
		JSONObject json = new JSONObject();
		json.put("msg","成功");
		String img = imgPath.split(",")[1];
		BASE64Decoder dec = new BASE64Decoder();
		try {
			byte[] bytes = dec.decodeBuffer(img);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(".\\src\\main\\webapp\\img\\1.jpg");
			out.write(bytes);
			out.flush();
			out.close();
			System.out.println("完毕");
		} catch (IOException e) {
			System.out.println("失败");
			e.printStackTrace();
		}
		return json;
	}
}
