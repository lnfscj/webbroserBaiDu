package com.app.view;

import com.example.search.R;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

public class CustomEditText extends EditText
{
	Context context;
    private Drawable dEnd ;
    private Rect rBounds;
    public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        initImage();
    }
    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initImage();
    }
    public CustomEditText(Context context) {
        super(context);
        this.context = context;
        initImage();
    }
 

    private void initImage() {
		// TODO Auto-generated method stub
		dEnd = context.getResources().getDrawable(R.drawable.url_img_refresh);
	}
	@Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_UP && dEnd!=null)
        {
            rBounds = dEnd.getBounds();
            final int x = (int)event.getX();
            final int y = (int)event.getY();
            //System.out.println("x:/y: "+x+"/"+y);
            //System.out.println("bounds: "+bounds.left+"/"+bounds.right+"/"+bounds.top+"/"+bounds.bottom);
            //check to make sure the touch event was within the bounds of the drawable
            if(x>=(this.getRight()-rBounds.width()) && x<=(this.getRight()-this.getPaddingRight())
                    && y>=this.getPaddingTop() && y<=(this.getHeight()-this.getPaddingBottom()))
            {
                //System.out.println("touch");
                this.setText("");
                event.setAction(MotionEvent.ACTION_CANCEL);//use this to prevent the keyboard from coming up
            }
        }
        return super.onTouchEvent(event);
    }
    @Override
    protected void finalize() throws Throwable
    {
    	dEnd = null;
        rBounds = null;
        super.finalize();
    }
}
