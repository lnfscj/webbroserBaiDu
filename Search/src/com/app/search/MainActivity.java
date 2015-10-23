package com.app.search;


import java.util.ArrayList;

import com.app.adapter.ColumnAdapter;
import com.app.fragment.LeftFragment;
import com.app.fragment.NaviFragment;
import com.app.fragment.RightFragment;
import com.app.fragment.TestFragment;
import com.app.tool.PageCountUtil;
import com.app.tool.ScreenUtils;
import com.app.view.ScrollVertical;
import com.app.view.ScrollVertical.OnScrollListener;
import com.example.search.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;





import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends SlidingFragmentActivity implements OnScrollListener {
	
	ScrollVertical scroll;
	RelativeLayout title_bar;
//	LinearLayout title_bar;
	private int searchLayoutTop;
	private int rlayoutTop;
    View column_cursor;
    LinearLayout search01,search02;
    LinearLayout rlayout;
	
	ViewPager pager;
	PagerTabStrip tabStrip;
	ArrayList<TextView> viewContainer = new ArrayList<>();
	ArrayList<String> titleContainer = new ArrayList<>();
	TextView tab1,tab2,tab3,tab4,tab5,tab6,tab7,tab8,tab9,tab10;
	ImageView cursor;
	LinearLayout mRadioGroup_content;
	HorizontalScrollView mColumnHorizontalScrollView;
	ImageView left,right;
	int currIndex;//currTab
	int bmpW;//the width of image
	int offset;//offset of image
	public String TAG = "tag";
	private int mScreenWidth = 0;
	public static SlidingMenu sm;
    FragmentManager fm;
	Fragment leftFragment,rightFragment;
	ImageView right_close,right_reset;
	
	TextView open_page;
	EditText url_goto;
	ImageView reset;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			setContentView(R.layout.activity_main);
			setBehindContentView(R.layout.left);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

			initSlidingMenu();
			initView();
			initColumnTab();
			initImage();
			setAdapter();
			setOnPageChangeListener();
			initLeft();
			
			
	
		
		
	}
	private void initView() {
		// TODO Auto-generated method stub
		try {
			open_page = (TextView) findViewById(R.id.url_open_page);
			url_goto = (EditText) findViewById(R.id.search);
			open_page.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent intent = new Intent(MainActivity.this,BookmarkActivity.class);
					
					startActivity(intent);
				}
			});
			url_goto.setOnClickListener(new OnClickListener() {
				
				

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Bundle data = new Bundle();
					data.putBoolean("isUrlSet", false);
//					data.putString("pageCount", pageCount);
					Intent intent = new Intent(MainActivity.this,InputUrlActivity.class);
					intent.putExtras(data);
					startActivity(intent);
				}
			});

			search01 = (LinearLayout)findViewById(R.id.search01);
			search02 = (LinearLayout)findViewById(R.id.search02);
			rlayout = (LinearLayout) findViewById(R.id.rlayout);
			scroll = (ScrollVertical) findViewById(R.id.myScrollView);
			scroll.setOnScrollListener(this);  
			title_bar = (RelativeLayout) findViewById(R.id.title_bar);
//			title_bar = (LinearLayout) findViewById(R.id.title_bar);
			column_cursor = findViewById(R.id.column_cursor);
			pager = (ViewPager) findViewById(R.id.viewpager);
			mColumnHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.hsv);
			mScreenWidth = ScreenUtils.getWindowsWidth(this);
			mRadioGroup_content = (LinearLayout) findViewById(R.id.ll_column);	
			left = (ImageView) findViewById(R.id.sliding_icon);
			left.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(sm.isMenuShowing()){
						sm.showContent();
					}else{
						sm.showMenu();
					}
				}
			});
			right = (ImageView) findViewById(R.id.home_icon);
			right.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(sm.isSecondaryMenuShowing()){
						sm.showContent();
					}else{
						sm.showSecondaryMenu();
					}
				}
			});
			right_close = (ImageView) findViewById(R.id.close);
			right_close.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					sm.showContent();
				}
			});
			right_reset = (ImageView) findViewById(R.id.reset);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void initSlidingMenu() {
		// TODO Auto-generated method stub
		
			try {
				sm = getSlidingMenu();
				
				sm.setMode(SlidingMenu.LEFT_RIGHT);//设置左右滑菜单
				sm.setSecondaryMenu(R.layout.right);
				
				sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);//设置要使菜单滑动，触碰屏幕的范围
				sm.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
				sm.getMenu().setFocusable(false);
				sm.setShadowWidthRes(R.dimen.shadow_width);//设置阴影图片的宽度
				sm.setShadowDrawable(R.drawable.shadow);//设置阴影图片
				sm.setFadeDegree(0.35F);//SlidingMenu滑动时的渐变程度
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			
		
//		sm.bringToFront();
		
	}
	private void initImage() {
		// TODO Auto-generated method stub
			cursor = (ImageView)findViewById(R.id.cursor);  
	        bmpW = cursor.getWidth();  
	        DisplayMetrics dm = new DisplayMetrics();  
	        getWindowManager().getDefaultDisplay().getMetrics(dm);  
	        int screenW = dm.widthPixels;  
	        offset = (screenW/6 - bmpW)/2;  
	          
	        //imgageview设置平移，使下划线平移到初始位置（平移一个offset）  
	        Matrix matrix = new Matrix();  
	        matrix.postTranslate(offset, 0);  
	        cursor.setImageMatrix(matrix);  
	}
	private void initColumnTab() {
		// TODO Auto-generated method stub
		tab1 = (TextView) findViewById(R.id.tab1);
		tab2 = (TextView) findViewById(R.id.tab2);
		tab3 = (TextView) findViewById(R.id.tab3);
		tab4 = (TextView) findViewById(R.id.tab4);
		tab5 = (TextView) findViewById(R.id.tab5);
		tab6 = (TextView) findViewById(R.id.tab6);
		tab7 = (TextView) findViewById(R.id.tab7);
		tab8 = (TextView) findViewById(R.id.tab8);
//		tab9 = (TextView) findViewById(R.id.tab9);
//		tab10 = (TextView) findViewById(R.id.tab10);

		
		tab1.setOnClickListener(new TabListener(0));
		tab2.setOnClickListener(new TabListener(1));
		tab3.setOnClickListener(new TabListener(2));
		tab4.setOnClickListener(new TabListener(3));
		tab5.setOnClickListener(new TabListener(4));
		tab6.setOnClickListener(new TabListener(5));
		tab7.setOnClickListener(new TabListener(6));
		tab8.setOnClickListener(new TabListener(7));
//		tab9.setOnClickListener(new TabListener(8));
//		tab10.setOnClickListener(new TabListener(9));
	}
	private void initLeft() {
		// TODO Auto-generated method stub
		
			leftFragment = new LeftFragment();
			rightFragment = new RightFragment();
			fm = getSupportFragmentManager();

//			ft.replace(R.id.fg_content, new TestFragment("")).commit();
		try {
			fm.beginTransaction().replace(R.id.fg_content, leftFragment).commit();
			fm.beginTransaction().replace(R.id.right_content, rightFragment).commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	



	
	public class TabListener implements OnClickListener {
		private int tabIndex = 0;

		public TabListener(int tabIndex) {
			super();
			this.tabIndex = tabIndex;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			pager.setCurrentItem(tabIndex);
		}

	}

	private void setOnPageChangeListener() {
		// TODO Auto-generated method stub
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			private int one = offset *2 +bmpW;
			
			
			public void onPageScrollStateChanged(int arg0) {
                try {
					Log.d(TAG, "--------changed:" + arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                try {
					Log.d(TAG, "-------scrolled arg0:" + arg0);
					Log.d(TAG, "-------scrolled arg1:" + arg1);
					Log.d(TAG, "-------scrolled arg2:" + arg2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
 
            @Override
            public void onPageSelected(int arg0) {
                
                Animation animation = new TranslateAnimation(currIndex*one,arg0*one,0,0);//平移动画  
                currIndex = arg0;  
                animation.setFillAfter(true);//动画终止时停留在最后一帧，不然会回到没有执行前的状态  
                animation.setDuration(200);//动画持续时间0.2秒  
                cursor.startAnimation(animation);//是用ImageView来显示动画的  
 //              ll.getChildAt(arg0).setSelected(true);
                 setColor(arg0);
                 selectTab(arg0);
            }
			
		});
	}
	private void setColor(int position) {
		// TODO Auto-generated method stub
		switch (position) {
		case 0:
			tab1.setTextColor(getResources().getColor(R.color.bg_color));
			tab2.setTextColor(getResources().getColor(R.color.black));
			tab3.setTextColor(getResources().getColor(R.color.black));
			tab4.setTextColor(getResources().getColor(R.color.black));
			tab5.setTextColor(getResources().getColor(R.color.black));
			tab6.setTextColor(getResources().getColor(R.color.black));
			tab7.setTextColor(getResources().getColor(R.color.black));
			tab8.setTextColor(getResources().getColor(R.color.black));
			break;
		case 1:
			tab2.setTextColor(getResources().getColor(R.color.bg_color));
			tab1.setTextColor(getResources().getColor(R.color.black));
			tab3.setTextColor(getResources().getColor(R.color.black));
			tab4.setTextColor(getResources().getColor(R.color.black));
			tab5.setTextColor(getResources().getColor(R.color.black));
			tab6.setTextColor(getResources().getColor(R.color.black));
			tab7.setTextColor(getResources().getColor(R.color.black));
			tab8.setTextColor(getResources().getColor(R.color.black));
			break;
		case 2:
			tab3.setTextColor(getResources().getColor(R.color.bg_color));
			tab2.setTextColor(getResources().getColor(R.color.black));
			tab1.setTextColor(getResources().getColor(R.color.black));
			tab4.setTextColor(getResources().getColor(R.color.black));
			tab5.setTextColor(getResources().getColor(R.color.black));
			tab6.setTextColor(getResources().getColor(R.color.black));
			tab7.setTextColor(getResources().getColor(R.color.black));
			tab8.setTextColor(getResources().getColor(R.color.black));
			break;
		case 3:
			tab4.setTextColor(getResources().getColor(R.color.bg_color));
			tab2.setTextColor(getResources().getColor(R.color.black));
			tab3.setTextColor(getResources().getColor(R.color.black));
			tab1.setTextColor(getResources().getColor(R.color.black));
			tab5.setTextColor(getResources().getColor(R.color.black));
			tab6.setTextColor(getResources().getColor(R.color.black));
			tab7.setTextColor(getResources().getColor(R.color.black));
			tab8.setTextColor(getResources().getColor(R.color.black));
			break;
		case 4:
			tab5.setTextColor(getResources().getColor(R.color.bg_color));
			tab2.setTextColor(getResources().getColor(R.color.black));
			tab3.setTextColor(getResources().getColor(R.color.black));
			tab4.setTextColor(getResources().getColor(R.color.black));
			tab1.setTextColor(getResources().getColor(R.color.black));
			tab6.setTextColor(getResources().getColor(R.color.black));
			tab7.setTextColor(getResources().getColor(R.color.black));
			tab8.setTextColor(getResources().getColor(R.color.black));
			break;
		case 5:
			tab6.setTextColor(getResources().getColor(R.color.bg_color));
			tab2.setTextColor(getResources().getColor(R.color.black));
			tab3.setTextColor(getResources().getColor(R.color.black));
			tab4.setTextColor(getResources().getColor(R.color.black));
			tab5.setTextColor(getResources().getColor(R.color.black));
			tab1.setTextColor(getResources().getColor(R.color.black));
			tab7.setTextColor(getResources().getColor(R.color.black));
			tab8.setTextColor(getResources().getColor(R.color.black));
			break;
		case 6:
			tab7.setTextColor(getResources().getColor(R.color.bg_color));
			tab2.setTextColor(getResources().getColor(R.color.black));
			tab3.setTextColor(getResources().getColor(R.color.black));
			tab4.setTextColor(getResources().getColor(R.color.black));
			tab5.setTextColor(getResources().getColor(R.color.black));
			tab6.setTextColor(getResources().getColor(R.color.black));
			tab1.setTextColor(getResources().getColor(R.color.black));
			tab8.setTextColor(getResources().getColor(R.color.black));
			break;
		case 7:
			tab8.setTextColor(getResources().getColor(R.color.bg_color));
			tab2.setTextColor(getResources().getColor(R.color.black));
			tab3.setTextColor(getResources().getColor(R.color.black));
			tab4.setTextColor(getResources().getColor(R.color.black));
			tab5.setTextColor(getResources().getColor(R.color.black));
			tab6.setTextColor(getResources().getColor(R.color.black));
			tab7.setTextColor(getResources().getColor(R.color.black));
			tab1.setTextColor(getResources().getColor(R.color.black));
			break;

		default:
			break;
		}
	}
	private void selectTab(int arg0) {
		// TODO Auto-generated method stub
		currIndex = arg0;
		for (int i = 0; i < mRadioGroup_content.getChildCount(); i++) {
			View checkView = mRadioGroup_content.getChildAt(arg0);
			int k = checkView.getMeasuredWidth();
			int l = checkView.getLeft();
			int i2 = l + k / 2 - mScreenWidth  / 2;
			// rg_nav_content.getParent()).smoothScrollTo(i2, 0);
			mColumnHorizontalScrollView.smoothScrollTo(i2, 0);
			// mColumnHorizontalScrollView.smoothScrollTo((position - 2) *
			// mItemWidth , 0);
		}
		//判断是否选中
		for (int j = 0; j <  mRadioGroup_content.getChildCount(); j++) {
			View checkView = mRadioGroup_content.getChildAt(j);
			boolean ischeck;
			if (j == arg0) {
				ischeck = true;
			} else {
				ischeck = false;
			}
			checkView.setSelected(ischeck);
		}
	}

	private void setAdapter() {
		// TODO Auto-generated method stub
		ArrayList<Fragment> list = new ArrayList<>();
		//list.add(new NaviFragment());
		for(int i = 0 ;i <8;i++){
			list.add(new TestFragment("tab"+i));
		}
		pager.setAdapter(new ColumnAdapter(getSupportFragmentManager(), list));

	
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("onResume");
		 try {
			scroll.post(new Runnable(){
				           @Override
				  	    public void run() {
				  	       // TODO Auto-generated method stub
				        	   scroll.scrollTo(0, title_bar.getMeasuredHeight());
				        	
				        	
				          }
				       });
			open_page.setText(""+PageCountUtil.PageCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private long mExitTime;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if(sm.isMenuShowing() ||sm.isSecondaryMenuShowing()){
				sm.showContent();
			}else {
				if ((System.currentTimeMillis() - mExitTime) > 2000) {
					Toast.makeText(this, "再按一次退出",
							Toast.LENGTH_SHORT).show();
					mExitTime = System.currentTimeMillis();
				} else {
					finish();
				}
			}
			return true;
		}
		//拦截MENU按钮点击事件，让他无任何操作
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);    
        if(hasFocus){  
        	try {
        		//searchLayoutTop = 400;//获取searchLayout的顶部位置
				searchLayoutTop = rlayout.getBottom()+column_cursor.getMeasuredHeight();//获取searchLayout的顶部位置
				rlayoutTop = rlayout.getTop();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
	}
	//监听滚动Y值变化，通过addView和removeView来实现悬停效果
	
	@Override
	public void onScroll(int scrollY) {
		// TODO Auto-generated method stub
		if(scrollY >= searchLayoutTop){  
			if (mColumnHorizontalScrollView.getParent()!=search01) {
				search02.removeView(mColumnHorizontalScrollView);
				search01.addView(mColumnHorizontalScrollView);
				column_cursor.setVisibility(View.VISIBLE);
			}
        }else{
        	if (mColumnHorizontalScrollView.getParent()!=search02) {
        		search01.removeView(mColumnHorizontalScrollView);
        		search02.addView(mColumnHorizontalScrollView);
        		column_cursor.setVisibility(View.GONE);	
        	
			}/*else if( rlayoutTop-scrollY>10){
				 scroll.post(new Runnable(){
			           @Override
			  	    public void run() {
			  	       // TODO Auto-generated method stub
			        	   scroll.scrollTo(0, title_bar.getMeasuredHeight());
			          }
			       });
			

			
			}*/
        
        }
	}

	



	
}
