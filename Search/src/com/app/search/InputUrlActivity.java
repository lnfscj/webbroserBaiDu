package com.app.search;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.adapter.HisoryListAdapter;
import com.app.bean.HistoryItem;
import com.app.tool.BitmapUtil;
import com.app.tool.PageCountUtil;
import com.example.search.R;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InputUrlActivity extends FragmentActivity {
	//titlebar
	RelativeLayout url_input;
	LinearLayout btn_frame;
	View btn_go;
	TextView btn_openmulti;
	LinearLayout btn_keyword;
	RelativeLayout text_layout;
	EditText input_text;
	View https,delete;
	TextView show_text;
	//searchHint
	FrameLayout url_hint;
	RelativeLayout searchedSite;
	TextView tab1,tab2;
	ListView suggestList;
	ListView historyList;
	TextView favouriteSite;
	TextView searchHint;
	//webtoolbar
	RelativeLayout webtoolbar;
	ImageButton btn_home,btn_webtoolbar_back,btn_webtoolbar_front,btn_webtoolbar_refrash,btn_webtoolbar_pause,btn_webtoolbar_bookmark,btn_webtoolbar_share,btn_webtoolbar_goapp;
	//webpage
	LinearLayout web_container;
	ProgressBar progress;
	WebView web;
	String pageCount;
	
	TabClickListener l;

//	List<HistoryItem> list;
	HisoryListAdapter adapter;
	SimpleDateFormat format;
	boolean isUrlSet = true;
	boolean isAddNew = true;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.url_input_window);
//		setContentView(R.layout.test);
		try {
			l = new TabClickListener();
//			list = new ArrayList<HistoryItem>();
			
			format = new SimpleDateFormat("MM.dd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initWebView();
		initWebToolBar();
		initTitleView();
		initHistoryView();
		
		try {
			Intent intent = getIntent();
			if(intent.getExtras().getBoolean("isUrlSet")){
				loadWebView(intent.getExtras().getString("url"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	private void initWebToolBar() {
		// TODO Auto-generated method stub
		webtoolbar = (RelativeLayout) findViewById(R.id.webtoolbar);
		btn_home = (ImageButton) findViewById(R.id.btn_home);
		btn_webtoolbar_back = (ImageButton) findViewById(R.id.btn_webtoolbar_back);
		btn_webtoolbar_front = (ImageButton) findViewById(R.id.btn_webtoolbar_front);
		btn_webtoolbar_refrash = (ImageButton) findViewById(R.id.btn_webtoolbar_refrash);
		btn_webtoolbar_pause = (ImageButton) findViewById(R.id.btn_webtoolbar_pause);
		btn_webtoolbar_bookmark = (ImageButton) findViewById(R.id.btn_webtoolbar_bookmark);
		btn_webtoolbar_share = (ImageButton) findViewById(R.id.btn_webtoolbar_share);
		btn_webtoolbar_goapp = (ImageButton) findViewById(R.id.btn_webtoolbar_goapp);
		
		btn_home.setOnClickListener(l);
		btn_webtoolbar_back.setOnClickListener(l);
		btn_webtoolbar_front.setOnClickListener(l);
		btn_webtoolbar_refrash.setOnClickListener(l);
		btn_webtoolbar_pause.setOnClickListener(l);
		btn_webtoolbar_bookmark.setOnClickListener(l);
		btn_webtoolbar_share.setOnClickListener(l);
		btn_webtoolbar_goapp.setOnClickListener(l);
	}



	private void initTitleView() {
		// TODO Auto-generated method stub
		try {
			url_input = (RelativeLayout) findViewById(R.id.url_input_titlebar);
			btn_frame = (LinearLayout) findViewById(R.id.url_btn_frame);
			btn_go = findViewById(R.id.url_go_btn);
			btn_openmulti = (TextView) findViewById(R.id.url_openmulti_btn);
			btn_keyword = (LinearLayout) findViewById(R.id.url_keywordsearch_btn);
			text_layout = (RelativeLayout) findViewById(R.id.url_input_window_text_layout);
			input_text = (EditText) findViewById(R.id.url_input_window_text);
			input_text.setSelection(input_text.getText().toString().length());
			https = findViewById(R.id.url_window_https);
			delete = findViewById(R.id.url_input_window_delete_button);
			show_text = (TextView) findViewById(R.id.url_window_text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		delete.setOnClickListener(l);
		btn_go.setOnClickListener(l);
		input_text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isAddNew = false;
				reSearch(url_hint.isShown());
				
			}
		});
	}

	protected void reSearch(boolean isHintShown) {
		// TODO Auto-generated method stub
//		System.out.println(isHintShown);
		if(!isHintShown){
			url_hint.setVisibility(View.VISIBLE);
			web_container.setVisibility(View.GONE);
			btn_go.setVisibility(View.VISIBLE);
			btn_openmulti.setVisibility(View.GONE);
			btn_keyword.setVisibility(View.GONE);
			delete.setBackground(getResources().getDrawable(R.drawable.selector_url_img_cancel));
			webtoolbar.setVisibility(View.GONE);
			input_text.setText("https://");
			input_text.setSelection(input_text.getText().toString().length());
		}
		if(adapter != null){
			searchHint.setVisibility(View.GONE);
			
		}
			
				
			
		
		
	}



	private void initWebView() {
		// TODO Auto-generated method stub
		web_container = (LinearLayout) findViewById(R.id.web_container);
		progress = (ProgressBar) findViewById(R.id.progress_bar);
		web = (WebView) findViewById(R.id.web_page);
		WebSettings settings = web.getSettings();

		settings.setBuiltInZoomControls(true);
		settings.setSupportZoom(true);
		settings.setDisplayZoomControls(true);
		settings.setJavaScriptEnabled(true);
		web.setWebViewClient(new HelloWebViewClient());
		web.setDrawingCacheEnabled(true);
		web.setWebChromeClient(new WebChromeClient(){
			
			@Override
			public void onReceivedTitle(WebView view, String title) {
				// TODO Auto-generated method stub
				super.onReceivedTitle(view, title);
				if(adapter == null){
					adapter = new HisoryListAdapter(getApplicationContext());
					suggestList.setAdapter(adapter);
				}
				adapter.addHistory(new HistoryItem(title, view.getUrl(), format.format(new Date()).toString()));
			}

			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				if (newProgress == 100) {
					progress.setVisibility(View.INVISIBLE);
					btn_webtoolbar_pause.setVisibility(View.INVISIBLE);
					btn_webtoolbar_refrash.setVisibility(View.VISIBLE);
					
	              } else {
	                  if (View.INVISIBLE == progress.getVisibility()) {
	                	  progress.setVisibility(View.VISIBLE);
	                  }
	                  progress.setProgress(newProgress);
	                  btn_webtoolbar_pause.setVisibility(View.VISIBLE);
	                  btn_webtoolbar_refrash.setVisibility(View.INVISIBLE);
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


	private void initHistoryView() {
		// TODO Auto-generated method stub
		
		try {
			url_hint = (FrameLayout) findViewById(R.id.url_suggest);
			searchedSite =  (RelativeLayout) findViewById(R.id.searchedSite);
			tab1 = (TextView) findViewById(R.id.tab_inputted);
			tab2 = (TextView) findViewById(R.id.tab_favorite);
			suggestList = (ListView) findViewById(R.id.url_suggest_list_view);
			historyList = (ListView) findViewById(R.id.list_suggest);
			favouriteSite = (TextView) findViewById(R.id.favouriteSite);
			searchHint = (TextView) findViewById(R.id.search_hint);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tab1.setSelected(true);		
		tab1.setOnClickListener(l);
		tab2.setOnClickListener(l);
		
//		try {
//			suggestList.setAdapter(adapter);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
	}
//	@Override
//	protected void onResume() {
//		// TODO Auto-generated method stub
//		super.onResume();
//		if(adapter != null){
//			searchHint.setVisibility(View.GONE);
//			suggestList.setVisibility(View.VISIBLE);
//		}
//	}
	
	
	class HelloWebViewClient extends WebViewClient {  
        public HelloWebViewClient() {
			// TODO Auto-generated constructor stub
		}

		@Override 
        public boolean shouldOverrideUrlLoading(WebView view, String url) {  
            view.loadUrl(url);  
            return true;  
        }  
	
		
        
    }  

	public class TabClickListener implements OnClickListener {
	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.tab_inputted:
				
				if(tab2.isSelected()){
//					if(adapter == null){
//						searchHint.setVisibility(View.VISIBLE);
//						
//					}else{
//						suggestList.setVisibility(View.VISIBLE);
//					}
					searchedSite.setVisibility(View.VISIBLE);
					favouriteSite.setVisibility(View.GONE);
				}
				tab1.setSelected(true);
				tab2.setSelected(false);
				break;
			case R.id.tab_favorite:
				if(tab1.isSelected()){
//					if(adapter == null){
//						searchHint.setVisibility(View.GONE);
//					}else{
//						suggestList.setVisibility(View.GONE);
//					}
					searchedSite.setVisibility(View.GONE);
					favouriteSite.setVisibility(View.VISIBLE);
					
				}
				tab2.setSelected(true);
				tab1.setSelected(false);
				break;
			case R.id.url_input_window_delete_button:
				if(web.isShown()){
					web.reload();					
				}else{
					input_text.setText("");
				}
				
				break;
			case R.id.url_go_btn:
				isUrlSet = false;
				loadWebView(input_text.getText().toString().trim());
				break;

			case R.id.btn_home:
				
				startActivity(new Intent(InputUrlActivity.this, MainActivity.class));
				//moveTaskToBack(true);
				break;
			case R.id.btn_webtoolbar_back:
				web.goBack();
				break;
			case R.id.btn_webtoolbar_front:
				web.goForward();
				break;
			case R.id.btn_webtoolbar_refrash:
				web.reload();
				break;
			case R.id.btn_webtoolbar_pause:
//				web.destroy();
				web.stopLoading();
				break;
			case R.id.btn_webtoolbar_bookmark:
				break;
			case R.id.btn_webtoolbar_share:
				break;
			case R.id.btn_webtoolbar_goapp:
				break;
			case R.id.url_openmulti_btn:
				requestBookmark();
				break;
			default:
				break;
			}
		}
	
	}
	int i = 0;
	public void loadWebView(String url) {
		// TODO Auto-generated method stub
//		reSearch(url_hint.isShown());
	
		
		if(url.substring(0, 7).equals("http://")||url.substring(0, 8).equals("https://")){
			web.loadUrl(url);
		}else{
			web.loadUrl("http://"+url);
		}
		
		
			
			
			input_text.setText(url);
			input_text.setSelection(input_text.getText().toString().length());
			url_hint.setVisibility(View.GONE);
			web_container.setVisibility(View.VISIBLE);
			btn_go.setVisibility(View.GONE);
			btn_openmulti.setVisibility(View.VISIBLE);	
			if(!isUrlSet&&isAddNew){
				btn_openmulti.setText(""+(++PageCountUtil.PageCount));
			}else{
				btn_openmulti.setText(""+PageCountUtil.PageCount);
			}
			
			btn_keyword.setVisibility(View.VISIBLE);
			delete.setBackground(getResources().getDrawable(R.drawable.url_img_refresh));
			webtoolbar.setVisibility(View.VISIBLE);
			
			btn_openmulti.setOnClickListener(l);
	}
	public void requestBookmark() {
		// TODO Auto-generated method stubif
		System.out.println("requestmark------urlSet::"+isUrlSet);
		System.out.println("requestmark------urlSet::"+isAddNew);
		Bundle data = new Bundle();
		Intent intent = new Intent(InputUrlActivity.this,BookmarkActivity.class);
		if(!isUrlSet&&isAddNew){
			System.out.println("requestmark------do::");
			ByteArrayOutputStream output = new ByteArrayOutputStream();//初始化一个流对象
			
	        web.getDrawingCache().compress(CompressFormat.PNG, 100, output);//把bitmap100%高质量压缩 到 output对象里
	     					        						
			
//			data.putByteArray("screenshot", output.toByteArray());
			BitmapUtil.bitmap = web.getDrawingCache();
			data.putString("title", web.getTitle());
			data.putString("url", web.getUrl());
//			data.putBoolean("hasAccessed", true);
			
			intent.putExtra("hasAccessed", true);
			
			//setResult(RESULT_OK, intent);
			//finish();
			//moveTaskToBack(true);
		}else{
			System.out.println("setResultWithCancel");
			data.putString("url", web.getUrl());
			intent.putExtra("hasAccessed", false);
		
			//finish();
			//moveTaskToBack(true);
		}
		intent.putExtra("isFromInuturl", true);
		intent.putExtras(data);
		startActivity(intent);
	}



	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}
}
