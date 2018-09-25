package com.yf.sd.service;

public interface UrlService {
	String GetHtmlTitle(String htmlUrl);
	String GetHtmlImg(String htmlUrl);
	String getHtmlSource(String htmlUrl);
	String getTitle(String htmlSource);
	String getImg(String url);
	String outTag(String s);
}
