package com.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.StackView;


public class CardContainerStack extends StackView {

	public CardContainerStack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public CardContainerStack(Context context, AttributeSet attrs) {
		super(context,attrs);
		// TODO Auto-generated constructor stub
	}
	public CardContainerStack(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO Auto-generated method stub
		
		final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);

            int childRight = child.getPaddingLeft() + child.getMeasuredWidth();
            int childBottom = child.getPaddingTop() + child.getMeasuredHeight();
            LayoutParams lp = (LayoutParams) child.getLayoutParams();

            child.layout(child.getPaddingLeft(), child.getPaddingTop() + 40,
                    childRight, childBottom + 40);

        }
        super.onLayout(changed, left, top, right, bottom);
	}

}
