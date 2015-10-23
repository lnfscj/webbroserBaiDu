package com.app.bean;


public class BookmarkItem {
	private String title;
	private byte[] map;
	private String url;

	public BookmarkItem(String title, byte[] map, String url) {
		super();
		this.title = title;
		this.map = map;
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public byte[] getMap() {
		return map;
	}
	public void setMap(byte[] map) {
		this.map = map;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
