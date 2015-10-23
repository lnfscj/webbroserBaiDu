package com.app.view;

import com.app.tool.DensityUtil;
import com.example.search.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class ServiceTextView extends TextView {
	Context context;
	String text;
	Drawable drawable;

	public ServiceTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	
	}

	public ServiceTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	
	}

	public ServiceTextView(Context context,String text,Drawable drawable) {
		super(context);
		// TODO Auto-generated constructor stub
		this.text = text;
		this.drawable = drawable;
		this.context = context;
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		this.setText(text);
		this.setCompoundDrawables(drawable, null, null, null);
		this.setGravity(Gravity.CENTER_VERTICAL);
		Resources resouce = context.getResources();
		int padding = DensityUtil.dip2px(context, resouce.getDimension(R.dimen.textview_padding));
		this.setPadding(padding, padding, 0, 0);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(params);
		this.setBackgroundColor(resouce.getColor(R.color.white));
		
	}
	

}
