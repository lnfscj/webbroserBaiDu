package com.app.view;



import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;


public class ScrollVertical extends ScrollView  {

	// 滑动距离及坐标  
    private float xDistance, yDistance, xLast, yLast;
	private OnScrollListener onScrollListener;  
	private int lastScrollY;
	private boolean isTitleShow;
	
    public boolean isTitleShow() {
		return isTitleShow;
	}
	public void setTitleShow(boolean isTitleShow) {
		this.isTitleShow = isTitleShow;
	}
	public ScrollVertical(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }  
	/** 
     * 设置滚动接口 
     * @param onScrollListener 
     */
	public void setOnScrollListener(OnScrollListener onScrollListener){
		this.onScrollListener = onScrollListener;
	}
	/** 
     * 用于用户手指离开MyScrollView的时候获取MyScrollView滚动的Y距离，然后回调给onScroll方法中 
     */  
    private Handler handler = new Handler() {  
  
        public void handleMessage(android.os.Message msg) {  
            int scrollY = ScrollVertical.this.getScrollY();  
              
            //此时的距离和记录下的距离不相等，在隔5毫秒给handler发送消息  
            if(lastScrollY != scrollY){  
                lastScrollY = scrollY;  
                handler.sendMessageDelayed(handler.obtainMessage(), 5);    
            }  
            if(onScrollListener != null){  
                onScrollListener.onScroll(scrollY);  
            }  
              
        };  
  
    }; 
    @Override  
    public boolean onInterceptTouchEvent(MotionEvent ev) {  
        switch (ev.getAction()) {  
            case MotionEvent.ACTION_DOWN:  
                xDistance = yDistance = 0f;  
                xLast = ev.getX();  
                yLast = ev.getY();  
                break;  
            case MotionEvent.ACTION_MOVE:  
                final float curX = ev.getX();  
                final float curY = ev.getY();  
  
                xDistance += Math.abs(curX - xLast);  
                yDistance += Math.abs(curY - yLast);  
                xLast = curX;  
                yLast = curY;  
  
                if(xDistance > yDistance){  
                    return false;  
                }    
        }  
  
        return super.onInterceptTouchEvent(ev);  
    }  
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
    	// TODO Auto-generated method stub
    	if(onScrollListener != null){  
            onScrollListener.onScroll(lastScrollY = this.getScrollY());  
        }  
        switch(ev.getAction()){
////        case MotionEvent.ACTION_DOWN:
////        	isTitleShow = true;
//        case MotionEvent.ACTION_MOVE:
////        	System.out.println(isTitleShow);
//        	if(!isTitleShow){
//        		return isTitleShow;
//        	}else{
//        		break;
//        	}
       
        
        case MotionEvent.ACTION_UP:  
             handler.sendMessageDelayed(handler.obtainMessage(), 20);    
       
            break;  
        }  
        
    	return super.onTouchEvent(ev);
       
    }

    /** 
     * 滚动的回调接口 
     */  
    public interface OnScrollListener{  
        /** 
         * 回调方法， 返回MyScrollView滑动的Y方向距离 
         */  
        public void onScroll(int scrollY);  
    }


}
