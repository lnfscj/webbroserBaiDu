package com.app.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.app.adapter.RightCheckAdapter;
import com.example.search.R;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.DragSortListView.RemoveListener;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RightFragment extends Fragment {

	View view;
	DragSortListView list;
	List<Body> l;
	RightCheckAdapter adapter;
	String[] titles = {"信息","招待","体育","皇家马德里","生活食品","购物","时装与美容","电影","图书和文化","汽车科技","游戏和应用","经济"};
	//监听器在手机拖动停下的时候触发  
    private DragSortListView.DropListener onDrop =  
       new DragSortListView.DropListener() {  
           @Override  
          public void drop(int from, int to) {//from to 分别表示 被拖动控件原位置 和目标位置  
              if (from != to) {  
            	  Body item = (Body)adapter.getItem(from);//得到listview的适配器  
                  adapter.remove(from);//在适配器中”原位置“的数据。  
                  adapter.insert(item, to);//在目标位置中插入被拖动的控件。  
              }  
          }  
      };  

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.right_behind, null);
		initData();
		adapter = new RightCheckAdapter(getActivity(),l);
		list = (DragSortListView) view.findViewById(R.id.check_list);
		list.setDropListener(onDrop);
		list.setDragEnabled(true);
//		
//		
		try {
			list.setAdapter(adapter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.setOnItemClickListener(new ListButtonListener());
		
		setListViewHeightBasedOnChildren(list);
		
		return view;
	}
	private void initData() {
		// TODO Auto-generated method stub
		try {
			List<String> list2 = new ArrayList<String>();
			for(int i = 0;i<titles.length;i++){
				list2.add(titles[i]);
			}		
 
			l=new ArrayList<Body>();  
			for(int i=0;i<list2.size();i++){  
			Body b=new Body();  
			   b.coin=list2.get(i);  
			   b.checked = false;
			   if(b.isChecked()){
				   b.src = R.drawable.edit_check_on;
			   }else{
				   b.src = R.drawable.edit_check_off;
			   }
//			   b.textColor = R.color.dark_gray;
//			   b.background = R.color.light_gray;
			   l.add(b);  
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         
	}

	public static void setListViewHeightBasedOnChildren(ListView listView) {
	    if(listView == null) return;
	    ListAdapter listAdapter = listView.getAdapter();
	    if (listAdapter == null) {
	        // pre-condition
	        return;
	    }
	    int totalHeight = 0;
	    for (int i = 0; i < listAdapter.getCount(); i++) {
	        View listItem = listAdapter.getView(i, null, listView);
	        listItem.measure(0, 0);
	        totalHeight += listItem.getMeasuredHeight();
	    }
	    ViewGroup.LayoutParams params = listView.getLayoutParams();
	    params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
	    listView.setLayoutParams(params);
	}
	public class ListButtonListener implements OnItemClickListener {



		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
//				Resources resource = getResources();
//				TextView text = (TextView) list.getChildAt(position).findViewById(R.id.name);
//				System.out.println(check.isChecked());
				if(l.get(position).isChecked()){
					l.get(position).src = R.drawable.edit_check_off;
					l.get(position).setChecked(false);
//					l.get(position).background = R.color.light_gray;
//					l.get(position).textColor = R.color.dark_gray;
					
				}else{
					l.get(position).src = R.drawable.edit_check_on;
					l.get(position).setChecked(true);
//					l.get(position).background = R.color.white;
//					l.get(position).textColor = R.color.black;
				}
				adapter.notifyDataSetChanged();

		}

	}
	
    
	public class Body {
		int src;
		int textColor;
		public int getTextColor() {
			return textColor;
		}
		public void setTextColor(int textColor) {
			this.textColor = textColor;
		}
		public int getBackground() {
			return background;
		}
		public void setBackground(int background) {
			this.background = background;
		}
		int background;
		String coin;
		boolean checked;
		  public boolean isChecked() {
			return checked;
		}
		public void setChecked(boolean checked) {
			this.checked = checked;
		}
		public int getSrc() {  
		        return src;  
		    }  
		    public void setSrc(int src) {  
		        this.src = src;  
		    }  
		    public String getCoin() {  
		        return coin;  
		    }  
		    public void setCoin(String coin) {  
		        this.coin = coin;  
		    }  

	}
	  
	
}
