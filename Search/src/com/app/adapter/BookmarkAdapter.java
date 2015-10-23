package com.app.adapter;

import com.example.search.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BookmarkAdapter extends BaseAdapter {
	Context context;

	public BookmarkAdapter(Context context) {
		super();
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
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
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.openpage_cardview, null);
			holder = new ViewHolder();
			holder.close = (Button) convertView.findViewById(R.id.closeButton);
			holder.title = (TextView) convertView.findViewById(R.id.cardTitle);
			holder.screenShot = (ImageView) convertView.findViewById(R.id.screenShot);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}
	
	class ViewHolder{
		ImageView screenShot;
		TextView title;
		Button close;
	}

}
