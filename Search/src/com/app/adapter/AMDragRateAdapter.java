package com.app.adapter;

import java.util.List;


import com.example.search.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AMDragRateAdapter extends BaseAdapter {

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}  
    
//    private Context context;  
//    List<body> items;//适配器的数据源  
//      
//       
//    public AMDragRateAdapter(Context context,List<body> list){  
//        this.context = context;  
//        this.items = list;  
//    }  
//      
//       
//  
//    @Override  
//    public int getCount() {  
//        // TODO Auto-generated method stub  
//        return items.size();  
//    }  
//  
//    @Override  
//    public Object getItem(int arg0) {  
//        // TODO Auto-generated method stub  
//        return items.get(arg0);  
//    }  
//  
//    @Override  
//    public long getItemId(int arg0) {  
//        // TODO Auto-generated method stub  
//        return arg0;  
//    }  
//      
//    public void remove(int arg0) {//删除指定位置的item  
//        items.remove(arg0);  
//        this.notifyDataSetChanged();//不要忘记更改适配器对象的数据源  
//    }  
//      
//    public void insert(body item, int arg0) {
//        items.add(arg0, item);  
//        this.notifyDataSetChanged();  
//    }  
//  
//    @Override  
//    public View getView(int position, View convertView, ViewGroup parent) {  
//        body item = (body)getItem(position);  
//        ViewHolder viewHolder;  
//        if(convertView==null){  
//            viewHolder = new ViewHolder();  
//            convertView = LayoutInflater.from(context).inflate(R.layout.am_rate_drag_item, null);  
//            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);  
//            viewHolder.ivCountryLogo = (ImageView) convertView.findViewById(R.id.ivCountryLogo);  
//            viewHolder.ivDelete = (ImageView) convertView.findViewById(R.id.click_remove);  
//            viewHolder.ivDragHandle = (ImageView) convertView.findViewById(R.id.drag_handle);  
//            convertView.setTag(viewHolder);  
//        }else{  
//            viewHolder = (ViewHolder) convertView.getTag();  
//        }  
//          
//        viewHolder.tvTitle.setText(item.coin);  
//        viewHolder.ivCountryLogo.setImageResource(item.src);  
//          
//           
//          
//        return convertView;  
//    }  
//      
//    class ViewHolder {  
//        TextView tvTitle;  
//        ImageView ivCountryLogo;  
//        ImageView ivDelete;  
//        ImageView ivDragHandle;  
//    }  
}  