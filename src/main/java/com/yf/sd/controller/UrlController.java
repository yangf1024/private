package com.yf.sd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yf.sd.pojo.User;
import com.yf.sd.pojo.url;
import com.yf.sd.service.UrlService;
import com.yf.sd.util.taobaoUrl;

@Controller
public class UrlController {
	@Autowired
	private UrlService urlService;

	@RequestMapping(value = "url")
	@ResponseBody
	public url getUsers(@RequestParam("html") String html) {
		url url = new url();
		String title = urlService.GetHtmlTitle(html);
		String img = urlService.GetHtmlImg(html);
		if (html != "") {
			if (title != null) {
				url.setState(1);
				url.setTitle(title);
				url.setImgUrl(img);
			} else {
				url.setState(0);
				url.setTitle("标题获取失败");
				url.setImgUrl("主图获取失败");
			}
		}else{
			url.setState(-1);
			url.setTitle("URL为空");
			url.setImgUrl("URL为空");
		}
		return url;
	}
}
