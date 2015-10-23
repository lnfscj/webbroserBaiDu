package com.app.bean;

import android.graphics.Bitmap;

public class CardItem {
	private String title;
	private Bitmap screenShot;
	public CardItem(String title, Bitmap screenShot) {
		super();
		this.title = title;
		this.screenShot = screenShot;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Bitmap getScreenShot() {
		return screenShot;
	}
	public void setScreenShot(Bitmap screenShot) {
		this.screenShot = screenShot;
	}
	

}
