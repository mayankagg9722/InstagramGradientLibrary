package com.example.animatebackground;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by mayankaggarwal on 20/03/17.
 */

public class AnimateActivity extends LinearLayout {

    private static final int DEFAULT_COLOR = Color.parseColor("#f754e1");
    private static final int DEFAULT_TIME_INTERVAL = 3000;
    private int backgroundColor = 0;
    private Boolean flag = true;
    private Handler hand = new Handler();
    private Runnable r;
    private View v;


    public AnimateActivity(Context context) {
        super(context);
        init(context, null);
    }

    public AnimateActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public interface setColor {
        void setColor(int color);
    }

    public interface setTimeInterval {
        void setTimeInterval(int timeInterval);
    }

    public void setColor(int color) {

        this.backgroundColor = color;
        setGradientAnimation(v, backgroundColor,0);
    }

    public void setTimeInterval(int timeInterval){
        if(timeInterval==0){
            setGradientAnimation(v, backgroundColor,DEFAULT_TIME_INTERVAL);
        }else{
            setGradientAnimation(v, backgroundColor,timeInterval);
        }
    }

    public void init(Context context, AttributeSet attrs) {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.my_layout, this, true);

        TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.AnimateActivity,
                0, 0
        );

        backgroundColor = styledAttributes.getColor(R.styleable.AnimateActivity_LayoutColor, DEFAULT_COLOR);

        setGradientAnimation(v, backgroundColor,0);

    }


    private void setGradientAnimation(View v, int backgroundColor,int timeInterval) {
        int dark = manipulateColor(backgroundColor, 0.4f);
        int dark1 = manipulateColor(backgroundColor, 0.6f);
        int dark2=  manipulateColor(backgroundColor, 0.8f);
        int actual = backgroundColor;
        int light1 = manipulateColor(backgroundColor, 1.2f);
        int light2 = manipulateColor(backgroundColor, 1.4f);
        int light = manipulateColor(backgroundColor, 1.6f);
        ColorDrawable[] color = {new ColorDrawable(light),new ColorDrawable(light1),new ColorDrawable(light2),
          new ColorDrawable(backgroundColor), new ColorDrawable(dark2),new ColorDrawable(dark1),new ColorDrawable(dark)};
        TransitionDrawable trans = new TransitionDrawable(color);
        v.setBackground(trans);
        trans.startTransition(timeInterval);
        repeatTransition(trans,timeInterval);
    }

    void repeatTransition(final TransitionDrawable trans, final int timeInterval) {
        r = new Runnable() {
            @Override
            public void run() {
                if (flag) {
//                    Log.d("tagg", "straight");
                    trans.startTransition(timeInterval);
                    flag = false;
                } else {
//                    Log.d("tagg", "reverse");
                    trans.reverseTransition(timeInterval);
                    flag = true;
                }
                hand.postDelayed(this, (2*timeInterval));
            }
        };
        hand.post(r);
    }


    public int manipulateColor(int color, float factor) {
        int a = Color.alpha(color);
        int r = Math.round((Color.red(color)) * factor);
        int g = Math.round(Color.green(color) * factor);
        int b = Math.round(Color.blue(color) * factor);
        int c = Color.argb(a,
                Math.min(r, 255),
                Math.min(g, 255),
                Math.min(b, 255));
        return c;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    //    ##########  Value Animator Animation For Gradient   ###############
//
//    private void changeBackground(final int light, final int dark) {
//        ValueAnimator anim = new ValueAnimator();
//        anim.setIntValues(light, dark);
//        anim.setEvaluator(new ArgbEvaluator());
//
//        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                Log.d("tagg", valueAnimator.getAnimatedValue().toString());
//                linearLayout.setBackgroundColor((Integer) valueAnimator.getAnimatedValue());
//            }
//        });
//        anim.setDuration(5000);
//        anim.setRepeatCount(ValueAnimator.INFINITE);
//        anim.start();
//    }
//
//    #############  (HSV color model change)  #################
//
//    public int manipulateHSVColor(int color, float factor) {
//        float[] hsv = new float[3];
//        int color = Color.parseColor(SetTheme.colorName);
//        Color.colorToHSV(color, hsv);
//        hsv[2] =0.8f * hsv[2];
//        int dark = Color.HSVToColor(hsv);
//
//
//        float[] hsv1 = new float[3];
//        int color1 = Color.parseColor(SetTheme.colorName);
//        Color.colorToHSV(color1, hsv1);
//
////        hsv1[2] = 1.0f - 0.8f * (1.0f - hsv1[2]);
//        hsv[2] =1.5f * hsv[2];
//        int light = Color.HSVToColor(hsv1);
//
//        changeBackground(light, dark);
//    }

}
