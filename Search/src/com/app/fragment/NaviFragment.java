package com.app.fragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.adapter.HisoryListAdapter;
import com.app.bean.HistoryItem;
import com.app.search.InputUrlActivity;
import com.example.search.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class NaviFragment extends Fragment {
	View view;
	GridView first,sencond;
	private String[] firstItemText,sencondItemText;
	String[] firstUrl,secondUrl;
	private int firstImageId;
	private LinearLayout web_container;
	private ProgressBar progress;
	private WebView web;
	private int type;
	public NaviFragment(int type) {
		super();
		this.type = type;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		getFirstResource();
//		getSencondResource();
		super.onCreate(savedInstanceState);
	}
//	private void getSencondResource() {
//		// TODO Auto-generated method stub
//		sencondItemText = new String[]{"汽车之家","苏宁易购","今日头条","1号店","东方财富","易车","热门游戏","安居客","去哪儿","双色球","途牛","智联招聘","到家","百度糯米","二次元","聚美优品","7k7k游戏","美拍","百度视频","看小说"};
//		secondUrl = "http://www.autohome.com.cn/";
//	}
	private void getFirstResource() {
		// TODO Auto-generated method stub
//		firstItemText = new String[]{"百度","新浪","腾讯","搜狐","网易","凤凰","淘宝","下载","同城","爱奇艺","赶集","携程","天猫","京东","唯品会","添加"};
//		firstImageId = R.drawable.ic_launcher;
		firstUrl = new String[]{"http://m.hao123.com",
				"http://m.hao123.com/news",
				"http://m.hao123.com/a/xiaoshuo?novelfrom=dh&z=2&level=1&page=index_h5&ver=2_android&pos=xiaoshuo_n2&category=xiaoshuo_n2%7C2%7Cxs&s=xs",
				"http://m.hao123.com/tejia/index/?idfrom=dht",
				"http://game.m.hao123.com/?gamefrom=wap",
				"http://m.hao123.com/m/o2o?z=2&from=mz",
				"http://top.baidu.com/m/hao123/",
				"http://m.hao123.com/n/v/caipiao?z=2"};
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_navi, null);
		//initView();
		initWebView();
		web.loadUrl("http://m.hao123.com");
		web.scrollTo(0,550);
		return view;
	}
/*	private void initView() {
		// TODO Auto-generated method stub
		first = (GridView) view.findViewById(R.id.first_grid);
		sencond = (GridView) view.findViewById(R.id.second_grid);
		first.setAdapter(getFirstAdapter());
		sencond.setAdapter(getSecondAdapter());
		first.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3) {
 //               Toast.makeText(getActivity(), index + "", 2).show();
                Bundle data = new Bundle();
                data.putBoolean("isUrlSet", true);
				data.putCharSequence("url", firstUrl);				
				Intent intent = new Intent(getActivity(),InputUrlActivity.class);
				intent.putExtras(data);
				startActivity(intent);
            }
        });
		sencond.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3) {
 //               Toast.makeText(getActivity(), index + "", 2).show();
                Bundle data = new Bundle();
                data.putBoolean("isUrlSet", true);
				data.putCharSequence("url", secondUrl);				
				Intent intent = new Intent(getActivity(),InputUrlActivity.class);
				intent.putExtras(data);
				startActivity(intent);
            }
        });
	}
	private ListAdapter getFirstAdapter() {
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < firstItemText.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemText", firstItemText[i]);
            map.put("itemImage", firstImageId);
            list.add(map);
        }
        // 该构造函数，这里说明一下
        // 第一个参数为new SimpleAdapter(Context, 上面的list,每一个项对应的itemView,itemView里显示的所有信息（要和list里的map里的名称一样） ,
        // itemView里控件id);
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), list, R.layout.firstgrid_item, new String[] { "itemText", "itemImage" },
                new int[] { R.id.grid_title, R.id.grid_image });
        return simpleAdapter;
	}
	private ListAdapter getSecondAdapter() {
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < sencondItemText.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemText", sencondItemText[i]);
            list.add(map);
        }
        // 该构造函数，这里说明一下
        // 第一个参数为new SimpleAdapter(Context, 上面的list,每一个项对应的itemView,itemView里显示的所有信息（要和list里的map里的名称一样） ,
        // itemView里控件id);
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), list, R.layout.sencondgrid_item, new String[] { "itemText" },
                new int[] { R.id.grid_title2 });
        return simpleAdapter;
	}
*/
	private void initWebView() {
		// TODO Auto-generated method stub
//		web_container = (LinearLayout) findViewById(R.id.web_container);
		progress = (ProgressBar) view.findViewById(R.id.progress_bar);
		web = (WebView) view.findViewById(R.id.web_page);
		WebSettings settings = web.getSettings();

		settings.setBuiltInZoomControls(true);
		settings.setSupportZoom(true);
		settings.setDisplayZoomControls(true);
		settings.setJavaScriptEnabled(true);
		web.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);  
	            return true;  
			}
		});
		web.setDrawingCacheEnabled(true);
		web.setWebChromeClient(new WebChromeClient(){
			
			@Override
			public void onReceivedTitle(WebView view, String title) {
				// TODO Auto-generated method stub
				super.onReceivedTitle(view, title);
//				if(adapter == null){
//					adapter = new HisoryListAdapter(getApplicationContext());
//					suggestList.setAdapter(adapter);
//				}
//				adapter.addHistory(new HistoryItem(title, view.getUrl(), format.format(new Date()).toString()));
			}

			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				if (newProgress == 100) {
					progress.setVisibility(View.INVISIBLE);
					
	              } else {
	                  if (View.INVISIBLE == progress.getVisibility()) {
	                	  progress.setVisibility(View.VISIBLE);
	                  }
	                  progress.setProgress(newProgress);
	              }
	              super.onProgressChanged(view, newProgress);
	          }
			
			
		});
		 web.setOnKeyListener(new OnKeyListener() {    
	      

				@Override
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					// TODO Auto-generated method stub
					if (event.getAction() == KeyEvent.ACTION_DOWN) {    
	                    if (keyCode == KeyEvent.KEYCODE_BACK && web.canGoBack()) {  
	                    	
	                        web.goBack();   //后退    
	  
	                        //webview.goForward();//前进  
	                        return true;    //已处理    
	                    }    
	                }    
	                return false;    
					
				}    
	        }
		 );  
	}
}
