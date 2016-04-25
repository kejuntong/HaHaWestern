package com.kejuntong.hahawestern.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by kejuntong on 16-04-24.
 */
public class SelectableImageButton extends ImageButton {
    public SelectableImageButton(Context context) {
        super(context);
        initView();
    }

    public SelectableImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SelectableImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    setAlpha(0.3f);
                } else if (event.getAction() == MotionEvent.ACTION_UP){
                    setAlpha(1.0f);
                }

                return false;
            }
        });
    }

}
