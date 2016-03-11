package com.example.youcyou.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Scroller;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

/**
 * @auther Chao Ye (yechao@didichuxing.com)
 * @since 16/3/4.
 */
public class CostumView extends FrameLayout {

    public CostumView(Context context) {
        super(context);
        scroller = new Scroller(context);
    }

    public CostumView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);

    }

    public CostumView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scroller = new Scroller(context);
    }


    int mLastX,mLastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean  returnValue  = super.onTouchEvent(event);

        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x  - mLastX;
                int deltaY = y  - mLastY;
                int translationX = (int) (ViewHelper.getTranslationX(this)+deltaX);
                int translationY = (int) (ViewHelper.getTranslationY(this)+deltaY);

                ViewHelper.setTranslationX(this,translationX);
                ViewHelper.setTranslationY(this,translationY);


                returnValue =  true;

            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;

       return returnValue;
    }

    Scroller scroller;

    public void smootScrollBy(int x,int y){
        smootScrollTo(scroller.getCurrX()+x,scroller.getCurrY()+y);
    }

    public void smootScrollTo(int destX,int destY){
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int deltaX = destX - scrollX;
        int deltaY = destY - scrollY;
        scroller.startScroll(scrollX,scrollY,deltaX,deltaY,1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if(scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(),scroller.getCurrY());
            postInvalidate();
        }
    }


    public void smootScrollAnimation(){
        ObjectAnimator.ofFloat(this,"translationX",0,100).setDuration(100).start();
    }
}
