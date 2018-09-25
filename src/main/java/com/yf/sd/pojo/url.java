package com.yf.sd.pojo;

public class url {
	private int state;
	private String title;
	private String imgUrl;
	private String price;

	@Override
	public String toString() {
		return "url{" +
				"state=" + state +
				", title='" + title + '\'' +
				", imgUrl='" + imgUrl + '\'' +
				", price='" + price + '\'' +
				'}';
	}

	public url() {
	}

	public url(int state, String title, String imgUrl, String price) {
		this.state = state;
		this.title = title;
		this.imgUrl = imgUrl;
		this.price = price;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getState() {
		return state;
	}

	public String getTitle() {
		return title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getPrice() {
		return price;
	}
}
