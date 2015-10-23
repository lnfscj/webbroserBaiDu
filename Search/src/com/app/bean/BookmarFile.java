package com.app.bean;

public class BookmarFile {
	private String title;
	private double mapCount;
	private String uri;
	private String url;
	public BookmarFile(String title, double mapCount, String uri, String url) {
		super();
		this.title = title;
		this.mapCount = mapCount;
		this.uri = uri;
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getMapCount() {
		return mapCount;
	}
	public void setMapCount(double mapCount) {
		this.mapCount = mapCount;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}




}
