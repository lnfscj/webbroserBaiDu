package com.app.search;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.app.adapter.BookmarkAdapter;
import com.app.bean.BookmarkItem;
import com.app.fragment.RightFragment.ListButtonListener;
import com.app.tool.BitmapUtil;
import com.app.tool.BookmarkUtll;
import com.app.tool.PageCountUtil;
import com.app.view.CardContainerStack;
import com.app.view.DiscoverContainerView;
import com.app.view.SlidingCard;
import com.app.view.UserVo;
import com.example.search.R;

import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.StackView;
import android.widget.TextView;


public class BookmarkActivity extends FragmentActivity {
	

	LinearLayout addNewPage;
	TextView pageCount;
	ImageButton pageHistory;
	
	LinearLayout tabLayout;
	FrameLayout cardLayout;
//	CardContainerStack card_list;
	Bitmap src;
	byte[] input ;
	String titles;
	List<BookmarkItem> list;
	int index = 0;
	CardListener cardListener;
	String mostRecentUrl;
//	View contentView;
//	ImageView bg ;
//	RelativeLayout titleArea;
//	TextView title;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.openpage_cardui_page);
		System.out.println("onCreate");
		initView();
		readDataList();
		cardListener = new CardListener();
		//initContent();
		getIntentFrom(getIntent());
		
		

	}

	
	private void initView() {
		// TODO Auto-generated method stub
		addNewPage = (LinearLayout) findViewById(R.id.addNewPageButton);
		pageCount = (TextView) findViewById(R.id.page_count_text);
		pageHistory = (ImageButton) findViewById(R.id.btn_openpage_history);
		tabLayout = (LinearLayout) findViewById(R.id.openpageLayout);
		cardLayout = (FrameLayout) findViewById(R.id.contentview);
//		try {
//			card_list = (CardContainerStack) findViewById(R.id.card_list);
//			card_list.setAdapter(new BookmarkAdapter(this));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ButtonListener l = new ButtonListener();
		addNewPage.setOnClickListener(l);
		pageCount.setOnClickListener(l);
		pageHistory.setOnClickListener(l);
	}
	private void readDataList() {
		// TODO Auto-generated method stub
		list = new ArrayList<BookmarkItem>();
		list = BookmarkUtll.BOOKMARK;
		
		pageCount.setText(""+PageCountUtil.PageCount);
	}
	
	private void initContent() {
		// TODO Auto-generated method stub
//		System.out.println(list.size());
		
		if(list.size()!=0){
			for (int i = 0; i < list.size(); i++) {
//				final int deleteIndex = i;
				
				try {
					LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
					final View contentView = LayoutInflater.from(this).inflate(R.layout.openpage_cardview, null);
					ImageView bg = (ImageView) contentView.findViewById(R.id.screenShot);
					RelativeLayout titleArea = (RelativeLayout) contentView.findViewById(R.id.titleArea);
					TextView title = (TextView) contentView.findViewById(R.id.cardTitle);
					Button button = (Button) contentView.findViewById(R.id.closeButton);
					button.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							try {
								int deleteIndex = cardLayout.indexOfChild(contentView);
								System.out.println("indexOfView-----"+cardLayout.indexOfChild(contentView));
								list.remove(deleteIndex);
								
								cardLayout.removeViewAt(deleteIndex);
								refreshContent();
								cardLayout.invalidate();
								
								
								System.out.println("afterRemove----listsize="+list.size());	
								System.out.println("afterRemove----cardNum="+cardLayout.getChildCount());
								
								
								pageCount.setText(""+(--PageCountUtil.PageCount));
//								System.out.println("indexOfView-----"+cardLayout.indexOfChild(contentView));
//								list.remove(cardLayout.indexOfChild(contentView));
//								System.out.println("afterRemove----listsize="+list.size());
//								cardLayout.removeView(contentView);
//								//cardLayout.notify();
//								System.out.println("afterRemove----cardNum="+cardLayout.getChildCount());
//								cardLayout.invalidate();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
						}
					});
					params.topMargin = i
							* getResources().getDimensionPixelSize(
									R.dimen.card_item_height)/list.size();

					contentView.setLayoutParams(params);
					titleArea.setVisibility(View.VISIBLE);
					title.setText(list.get(i).getTitle());
					input = list.get(i).getMap();
					if(input != null){
						bg.setImageBitmap(BitmapFactory.decodeByteArray(input, 0, input.length));
					}
//					bg.setImageBitmap(list.get(i).getMap());
					cardLayout.addView(contentView);
					pageCount.setText(""+PageCountUtil.PageCount);
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		}
		for(int i = 0;i<cardLayout.getChildCount();i++){
			cardLayout.getChildAt(i).setOnClickListener(cardListener);
		}

	}
	


//	@Override
//	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
//		// TODO Auto-generated method stub
//		super.onActivityResult(arg0, arg1, arg2);
//		
//		System.out.println("onActivityResult");
//		mostRecentUrl = arg2.getExtras().getString("url");
//		if(arg0 == 1){
//		switch (arg1) {
//		case RESULT_OK:
//			
//			getIntentFrom(arg2);
//			System.out.println("beforeRemove----listsize="+list.size());
//			System.out.println("beforeRemove-----cardNum="+cardLayout.getChildCount());
//			break;
//		case RESULT_CANCELED:
//			refreshContent();
//		default:
//			break;
//		}
//		}
//		
//	}
	private void getIntentFrom(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println(intent.getBooleanExtra("hasAccessed", false));
		
		try {
			if(intent.getBooleanExtra("isFromInuturl", false)){
				if(intent.getBooleanExtra("hasAccessed", false)){
					
//					list.add(new BookmarkItem(intent.getExtras().getString("title"), intent.getExtras().getByteArray("screenshot")));
					ByteArrayOutputStream output = new ByteArrayOutputStream();//初始化一个流对象
					
					BitmapUtil.bitmap.compress(CompressFormat.PNG, 100, output);//把bitmap100%高质量压缩 到 output对象里
					list.add(new BookmarkItem(intent.getExtras().getString("title"), output.toByteArray(),intent.getExtras().getString("url")));
					output = null;
					BitmapUtil.bitmap = null;
					index++;
					refreshContent();
					
			}else{
				refreshContent();
			}
				mostRecentUrl = intent.getExtras().getString("url");
		}else{
			initContent();
		}
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void refreshContent() {
		// TODO Auto-generated method stub
		
			cardLayout.removeAllViews();
			initContent();
		
	}

	public class ButtonListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.addNewPageButton:
				Intent intent = new Intent(BookmarkActivity.this,InputUrlActivity.class);
				Bundle data = new Bundle();
				data.putBoolean("isUrlSet", false);
//				data.putString("pageCount", ""+list.size());
				intent.putExtras(data);
				startActivity(intent);
				break;
			case R.id.page_count_text:
//				System.out.println(Integer.parseInt(pageCount.getText().toString()));
				if(list.size() != 0){
					starWithUrl(mostRecentUrl);
				}else{
					finish();
				}
				
	//			moveTaskToBack(true);
				break;
			case R.id.btn_openpage_history:
				break;
			

			default:
				break;
			}
		}

	}
	public class CardListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
//			System.out.println("card click"+cardLayout.getChildCount());
			for(int i = 0;i<cardLayout.getChildCount();i++){
				int index  = i;
				if (v == cardLayout.getChildAt(index)) {
					System.out.println("card click"+index);
					try {
					
						starWithUrl(list.get(index).getUrl());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
					//mostRecentUrl = list.get(i).getUrl();
				}
	
			}
		}
		
	}
	public void starWithUrl(String url){
		Intent intent = new Intent(BookmarkActivity.this,InputUrlActivity.class);
		Bundle data = new Bundle();
		data.putBoolean("isUrlSet", true);
		data.putString("url", url);
		intent.putExtras(data);
		
		startActivity(intent);
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK) {
	    	BookmarkUtll.BOOKMARK = list;
	        finish();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
}
