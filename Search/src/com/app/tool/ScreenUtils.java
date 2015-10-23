package com.app.tool;

import android.app.Activity;
import android.util.DisplayMetrics;

public class ScreenUtils {

	/** ��ȡ��Ļ�Ŀ�� */
	public final static int getWindowsWidth(Activity activity) {
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.widthPixels;
	}
	/** ��ȡ��Ļ�ĸ߶� */
	public final static int getWindowsHight(Activity activity) {
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.heightPixels;
	}
}
