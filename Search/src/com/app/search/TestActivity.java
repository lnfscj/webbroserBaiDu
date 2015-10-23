package com.app.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.app.adapter.AMDragRateAdapter;
import com.app.fragment.LeftFragment;
import com.app.tool.ScreenUtils;
import com.app.view.ScrollVertical;
import com.app.view.ScrollVertical.OnScrollListener;
import com.example.search.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.DragSortListView.RemoveListener;


import android.app.Notification.Action;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.FrameLayout.LayoutParams;

public class TestActivity extends FragmentActivity  {

	

	public SlidingMenu sm;
	private HorizontalScrollView search_edit;
	private ScrollVertical myScrollView;
    private int searchLayoutTop;
    
    LinearLayout search01,search02;
    RelativeLayout rlayout;
	                       
	    @Override
		public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  

				setContentView(R.layout.test);
				FrameLayout fl = (FrameLayout) findViewById(R.id.content);
				for(int i=0;i<4;i++){
//					TextView tv = new TextView(this);
					LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
					View tv = LayoutInflater.from(this).inflate(R.layout.openpage_cardview,null);
					ImageView bg = (ImageView) tv.findViewById(R.id.screenShot);
					RelativeLayout titleArea = (RelativeLayout) tv.findViewById(R.id.titleArea);
					TextView title = (TextView) tv.findViewById(R.id.cardTitle);
					Button button = (Button) tv.findViewById(R.id.closeButton);
					params.topMargin = i
							* getResources().getDimensionPixelSize(
									R.dimen.card_item_height)/4;

					tv.setLayoutParams(params);
					titleArea.setVisibility(View.VISIBLE);
					title.setText("test"+i);
					
					bg.setImageDrawable(getResources().getDrawable(R.drawable.bg_01));
					
					fl.addView(tv);
					System.out.println(fl.getChildCount());
				}
				System.out.println(fl.getChildCount());
		
//	        init();
		}
	    /*
		private void init() {
			try {
				search_edit = (HorizontalScrollView) findViewById(R.id.hsv);
				myScrollView = (ScrollVertical)findViewById(R.id.myScrollView);
				search01 = (LinearLayout)findViewById(R.id.search01);
				search02 = (LinearLayout)findViewById(R.id.search02);
				rlayout = (RelativeLayout)findViewById(R.id.rlayout);
				myScrollView.setOnScrollListener(this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        
		}

		@Override
		public void onWindowFocusChanged(boolean hasFocus) {
			super.onWindowFocusChanged(hasFocus);    
	        try {
				if(hasFocus){  
					searchLayoutTop = rlayout.getBottom();//获取searchLayout的顶部位置
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//监听滚动Y值变化，通过addView和removeView来实现悬停效果
		@Override
		public void onScroll(int scrollY) {
			try {
				if(scrollY >= searchLayoutTop){  
					if (search_edit.getParent()!=search01) {
						search02.removeView(search_edit);
						search01.addView(search_edit);
					}
				}else{
					if (search_edit.getParent()!=search02) {
						search01.removeView(search_edit);
						search02.addView(search_edit);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
}