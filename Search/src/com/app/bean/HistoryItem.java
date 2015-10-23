package com.app.bean;

public class HistoryItem {
	private String title;
	private String url;
	private String date;
	
	
	public HistoryItem(String title, String url, String date) {
		super();
		this.title = title;
		this.url = url;
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
