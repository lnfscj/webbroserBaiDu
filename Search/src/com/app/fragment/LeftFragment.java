package com.app.fragment;

import java.util.List;
import java.util.Map;

import com.app.adapter.LeftServiceAdapter;
import com.app.search.MainActivity;
import com.app.view.NoScrollListView;
import com.app.view.ServiceTextView;
import com.example.search.R;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LeftFragment extends Fragment {

	View view;
	LinearLayout l1,l2;
	int[] image1,image2;
	String[] title1,title2;
	
	TextView head_login;
	ImageView head_ring,head_exit;
	TextView btn_subscribe,btn_mail,btn_band,btn_message,btn_coffee,btn_blog,btn_bootmark,btn_setting;
	TextView pay_left,pay_right;
	TextView stock_setting,stock_start;
	TextView tab1,tab2,tab3,tab4;
	LeftClickListener buttonListener;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		image1 = new int[]{R.drawable.widget_icon_pwe1,R.drawable.widget_icon_pwe2,R.drawable.widget_icon_pwe3,R.drawable.widget_icon_pwe4,R.drawable.widget_icon_pwe5};
		image2 = new int[] {R.drawable.widget_icon_pwe6,R.drawable.widget_icon_pwe7,R.drawable.widget_icon_pwe8,R.drawable.widget_icon_pwe9,R.drawable.widget_icon_pwe10};
		title1 = new String[]{"博客","知识","体育","咖啡","漫画"};
		title2 = new String[]{"条子","电影","股票","天气","备忘录"};
		buttonListener = new LeftClickListener();

	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		try {
			view = inflater.inflate(R.layout.left_behind, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initView();
		initAppList();
		initClickListener();
		
		return view;
	}
	
	private void initClickListener() {
		// TODO Auto-generated method stub
		head_login.setOnClickListener(buttonListener);
		head_ring.setOnClickListener(buttonListener);
		head_exit.setOnClickListener(buttonListener);
		btn_subscribe.setOnClickListener(buttonListener);
		btn_mail.setOnClickListener(buttonListener);
		btn_band.setOnClickListener(buttonListener);
		btn_message.setOnClickListener(buttonListener);
		btn_coffee.setOnClickListener(buttonListener);
		btn_blog.setOnClickListener(buttonListener);
		btn_bootmark.setOnClickListener(buttonListener);
		btn_setting.setOnClickListener(buttonListener);
		pay_left.setOnClickListener(buttonListener);
		pay_right.setOnClickListener(buttonListener);
		stock_setting.setOnClickListener(buttonListener);
		stock_start.setOnClickListener(buttonListener);
		tab1.setOnClickListener(buttonListener);
		tab2.setOnClickListener(buttonListener);
		tab3.setOnClickListener(buttonListener);
		tab4.setOnClickListener(buttonListener);
	}

	private void initView() {
		// TODO Auto-generated method stub
		try {
			l1 = (LinearLayout) view.findViewById(R.id.list_left);
			l2 = (LinearLayout) view.findViewById(R.id.list_right);
			head_login = (TextView) view.findViewById(R.id.login);
			head_ring = (ImageView) view.findViewById(R.id.alarm);
			head_exit = (ImageView) view.findViewById(R.id.close);
			btn_subscribe = (TextView) view.findViewById(R.id.use_me);
			btn_mail = (TextView) view.findViewById(R.id.user_mail);
			btn_band = (TextView) view.findViewById(R.id.user_message);
			btn_message = (TextView) view.findViewById(R.id.user_talktalk);
			btn_coffee = (TextView) view.findViewById(R.id.user_cafe);
			btn_blog = (TextView) view.findViewById(R.id.user_blog);
			btn_bootmark = (TextView) view.findViewById(R.id.user_bookmark);
			btn_setting = (TextView) view.findViewById(R.id.user_setting);
			pay_left = (TextView) view.findViewById(R.id.pay_start);
			pay_right = (TextView) view.findViewById(R.id.pay_end);
			stock_setting = (TextView) view.findViewById(R.id.service_settings);
			stock_start = (TextView) view.findViewById(R.id.service_more);
			tab1 = (TextView) view.findViewById(R.id.btn_login);
			tab2 = (TextView) view.findViewById(R.id.btn_pc);
			tab3 = (TextView) view.findViewById(R.id.btn_url);
			tab4 = (TextView) view.findViewById(R.id.btn_page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void initAppList() {
		// TODO Auto-generated method stub
		for(int i = 0;i<5;i++){
			Drawable drawable1= getResources().getDrawable(image1[i]);  
			/// 这一步必须要做,否则不会显示.  
			drawable1.setBounds(-(drawable1.getIntrinsicWidth()/4), 0,drawable1.getIntrinsicWidth()/4 , drawable1.getIntrinsicHeight()/2); 
			TextView tv1 = new ServiceTextView(getActivity(), title1[i], drawable1);
			
			l1.addView(tv1);
			
			Drawable drawable2= getResources().getDrawable(image2[i]);  
			/// 这一步必须要做,否则不会显示.  
			drawable2.setBounds(-(drawable1.getIntrinsicWidth()/4), 0, drawable2.getIntrinsicWidth()/4, drawable2.getIntrinsicWidth()/2); 
			TextView tv2 = new ServiceTextView(getActivity(), title2[i], drawable2);
			l2.addView(tv2);
		}
	}



	public class LeftClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.login:
				
				break;
			case R.id.alarm:
				break;
			case R.id.close:
				MainActivity.sm.showContent();
				break;
			case R.id.use_me:
				break;
			case R.id.user_mail:
				break;
			case R.id.user_message:
				break;
			case R.id.user_talktalk:
				break;
			case R.id.user_cafe:
				break;
			case R.id.user_blog:
				break;
			case R.id.user_bookmark:
				break;
			case R.id.user_setting:
				break;
			case R.id.pay_start:
				break;
			case R.id.pay_end:
				break;
			case R.id.service_settings:
				break;
			case R.id.service_more:
				break;
			case R.id.btn_login:
				break;
			case R.id.btn_pc:
				break;
			case R.id.btn_url:
				break;
			case R.id.btn_page:
				break;

			default:
				break;
			}
		}

	}

}
