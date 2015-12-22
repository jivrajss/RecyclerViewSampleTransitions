package com.example.android.xyztouristattractions.ui;

/**
 * Created by jivraj.singh on 22-12-2015.
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class DynamicImageView extends ImageView {

    private final static String TAG = DynamicImageView.class.getSimpleName();

    public DynamicImageView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicImageView(final Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        final Drawable d = this.getDrawable();

        if (d != null) {
            // ceil not round - avoid thin vertical gaps along the left/right edges
            final int width = MeasureSpec.getSize(widthMeasureSpec);
            final int height = (int) Math.ceil(width * (float) d.getIntrinsicHeight() / d.getIntrinsicWidth());
            this.setMeasuredDimension(width, height);
//            Log.d(TAG , width+ "---"+height);
        } else {
//        	Log.d(TAG , "Else--"+widthMeasureSpec+ "---"+ heightMeasureSpec);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
