package com.yf.sd.pojo;

public class User {
	private int id;
	//用户名
	private String username;
	//密码
	private String pwd;
	//手机号
	private String phone;
	//推荐人
	private String recom;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", pwd='" + pwd + '\'' +
				", phone='" + phone + '\'' +
				", recom='" + recom + '\'' +
				'}';
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setRecom(String recom) {
		this.recom = recom;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPwd() {
		return pwd;
	}

	public String getPhone() {
		return phone;
	}

	public String getRecom() {
		return recom;
	}
}
