package com.app.adapter;

import com.example.search.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.TextView;

public class LeftServiceAdapter extends BaseAdapter {
	Context context;
	int index;


	public LeftServiceAdapter(Context context, int index) {
		super();
		this.context = context;
		this.index = index;
	}

	int[] image1 = new int[]{R.drawable.widget_icon_pwe1,R.drawable.widget_icon_pwe2,R.drawable.widget_icon_pwe3,R.drawable.widget_icon_pwe4,R.drawable.widget_icon_pwe5};
	int[] image2 = new int[] {R.drawable.widget_icon_pwe6,R.drawable.widget_icon_pwe7,R.drawable.widget_icon_pwe8,R.drawable.widget_icon_pwe9,R.drawable.widget_icon_pwe10};
	String[] title1 = new String[]{"博客","知识","体育","咖啡","漫画"};
	String[] title2 = new String[]{"条子","电影","股票","天气","备忘录"};

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return title1[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		

//		if(convertView == null){
//			convertView = LayoutInflater.from(context).inflate(R.layout.left_list_item, null);
//			holder = new ViewHolder();
//			holder.tv = (TextView) convertView.findViewById(R.id.tv);
//			convertView.setTag(holder);
//		}else{
//			holder = (ViewHolder) convertView.getTag();
//		}
//		
//		
//		if(index == 1){
//			holder.tv.setText(title1[position]);
//			Drawable drawable= context.getResources().getDrawable(image1[position]);  
//			/// 这一步必须要做,否则不会显示.  
//			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight()); 
//			holder.tv.setCompoundDrawables(drawable, null, null, null);
//		}else{
//			holder.tv.setText(title2[position]);
//			Drawable drawable= context.getResources().getDrawable(image2[position]);  
//			/// 这一步必须要做,否则不会显示.  
//			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight()); 
//			holder.tv.setCompoundDrawables(drawable, null, null, null);
//		}
		
		return convertView;
	}
	class ViewHolder{
		TextView tv;
	}

}
