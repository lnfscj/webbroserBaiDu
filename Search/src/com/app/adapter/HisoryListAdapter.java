package com.app.adapter;

import java.util.ArrayList;
import java.util.List;

import com.app.bean.HistoryItem;
import com.example.search.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HisoryListAdapter extends BaseAdapter {
	List<HistoryItem> list = new ArrayList<HistoryItem>();
	Context context;

	public HisoryListAdapter(List<HistoryItem> list, Context context) {
		super();
//		this.list = list;
		
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder ;
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.url_prepared_list_item, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.text_title);
			holder.url = (TextView) convertView.findViewById(R.id.text_url);
			holder.date = (TextView) convertView.findViewById(R.id.text_date);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.title.setText(list.get(position).getTitle());
		holder.url.setText(list.get(position).getUrl());
		holder.date.setText(list.get(position).getDate());
		return convertView;
	}
	public HisoryListAdapter(Context context) {
		super();
		this.context = context;
	}
	class ViewHolder{
		TextView title;
		TextView url;
		TextView date;
	}
	
	public void addHistory(HistoryItem history){
//		System.out.println(list.size());
		if(list.size() >= 0){
			list.add(0, history);
		}
		
//		list.add(history);
		this.notifyDataSetChanged();
		this.notifyDataSetInvalidated();
	}
	public void removeHistory(int position){
		list.remove(position);
		this.notifyDataSetChanged();
		this.notifyDataSetInvalidated();
	}
}
