package com.app.view;



import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;


public class ScrollVertical extends ScrollView  {

	// �������뼰����  
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
     * ���ù����ӿ� 
     * @param onScrollListener 
     */
	public void setOnScrollListener(OnScrollListener onScrollListener){
		this.onScrollListener = onScrollListener;
	}
	/** 
     * �����û���ָ�뿪MyScrollView��ʱ���ȡMyScrollView������Y���룬Ȼ��ص���onScroll������ 
     */  
    private Handler handler = new Handler() {  
  
        public void handleMessage(android.os.Message msg) {  
            int scrollY = ScrollVertical.this.getScrollY();  
              
            //��ʱ�ľ���ͼ�¼�µľ��벻��ȣ��ڸ�5�����handler������Ϣ  
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
     * �����Ļص��ӿ� 
     */  
    public interface OnScrollListener{  
        /** 
         * �ص������� ����MyScrollView������Y������� 
         */  
        public void onScroll(int scrollY);  
    }


}
