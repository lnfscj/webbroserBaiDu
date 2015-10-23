package com.app.adapter;

import java.util.List;


import com.app.fragment.RightFragment.Body;
import com.example.search.R;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RightCheckAdapter extends BaseAdapter {
	Context context;
	OnClickListener itemListener;
	List<Body> items;//适配器的数据源  
    
    
    public RightCheckAdapter(Context context,List<Body> list){  
        this.context = context;  
        this.items = list;  
        
    }  



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	public void remove(int arg0) {//删除指定位置的item  
		items.remove(arg0);  
        this.notifyDataSetChanged();//不要忘记更改适配器对象的数据源  
    }  
    public void insert(Body item, int arg0) {
    	items.add(arg0, item);  
        this.notifyDataSetChanged();  
    } 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Resources resource;
		resource = context.getResources();
		final ViewHolder holder;
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.right_list_item, null);
			holder = new ViewHolder();
			holder.check = (CheckBox) convertView.findViewById(R.id.check);
			holder.name = (TextView) convertView.findViewById(R.id.name);
			holder.move = (ImageView) convertView.findViewById(R.id.move);
			holder.background = (RelativeLayout) convertView.findViewById(R.id.background);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
//		holder.check.setOnCheckedChangeListener(itemListener);
		holder.name.setText(items.get(position).getCoin());
		
		holder.check.setButtonDrawable(items.get(position).getSrc());
		convertView.setBackgroundColor(items.get(position).getBackground());
		if(items.get(position).isChecked()){
			holder.name.setTextColor(resource.getColor(R.color.black));
			holder.background.setBackgroundColor(resource.getColor(R.color.white));
		}else{
			holder.name.setTextColor(resource.getColor(R.color.dark_gray));
			holder.background.setBackgroundColor(resource.getColor(R.color.light_gray));
		}
		return convertView;
	}
	class ViewHolder{
		CheckBox check;
		TextView name;
		ImageView move;
		RelativeLayout background;
	}

}
