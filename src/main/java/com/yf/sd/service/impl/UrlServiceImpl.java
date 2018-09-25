package com.yf.sd.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.yf.sd.service.UrlService;
@Service
public class UrlServiceImpl implements UrlService
{
	public String GetHtmlTitle(String htmlUrl) {
		String htmlSource = "";
		htmlSource = getHtmlSource(htmlUrl);// 获取源码
		String title = getTitle(htmlSource); // 标题
		return title;
	}
	public String GetHtmlImg(String htmlUrl) {
		String htmlSource = "";
		htmlSource = getHtmlSource(htmlUrl);// 获取源码
		String img = getImg(htmlSource);// 主图
		return img;
	}


	/**
	 * 页面源码
	 * 
	 * @param htmlUrl
	 * @return
	 */
	public String getHtmlSource(String htmlUrl) {
		URL url;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(htmlUrl);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "gbk"));
			String temp;
			while ((temp = in.readLine()) != null) {
				sb.append(temp);
			}
			in.close();
		} catch (MalformedURLException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 标题
	 * 
	 * @param htmlSource
	 * @return
	 */
	public String getTitle(String htmlSource) {
		List<String> list = new ArrayList<String>();
		String title = "";
		Pattern pa = Pattern.compile("<title>.*?</title>");// 提取title

		Matcher ma = pa.matcher(htmlSource);
		while (ma.find()) {
			list.add(ma.group());
		}
		for (int i = 0; i < list.size(); i++) {
			title = title + list.get(i);
		}
		return outTag(title);
	}

	public String getImg(String url) {
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		String title = "";
		String title2 = "";
		Pattern pa2 = Pattern.compile("<img id=\"J_ImgBooth\".*?>");
		Pattern pa3 = Pattern.compile("src=(\"|\')(.*?)(\"|\')");
		Matcher ma = pa2.matcher(url);
		while (ma.find()) {
			list.add(ma.group());
		}
		for (int i = 0; i < list.size(); i++) {
			title = title + list.get(i);
		}
		System.out.println(pa2	);
		System.out.println(ma	);
		Matcher ma2 = pa3.matcher(title);
		while (ma2.find()) {
			list2.add(ma2.group());
		}
		for (int i = 0; i < list2.size(); i++) {
			title2 = title2 + list2.get(i);
		}
		title2 = title2.replaceAll("src=\"//", "").replaceAll("\"", "");
//		System.out.println(title2);
		return title2;
	}

	public String outTag(String s) {
		return s.replaceAll("<.*?>", "");
	}


}
