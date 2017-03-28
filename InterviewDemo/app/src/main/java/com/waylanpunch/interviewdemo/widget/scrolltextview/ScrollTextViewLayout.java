package com.waylanpunch.interviewdemo.widget.scrolltextview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.waylanpunch.interviewdemo.R;

/**
 * Created by pc on 2017/3/28.
 * 另外一种实现方式：http://blog.csdn.net/coderinchina/article/details/52207027
 */

public class ScrollTextViewLayout extends LinearLayout {
    private int mDuration = 500;
    private int mIndex = 0;
    private String[] mTextArray;
    private int mTextHight;
    private TextView mTextView;


    Runnable dismiss = new Runnable()
    {
        public void run()
        {
            int i = mTextHight;
            TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, mTextHight, i * -1);
            localTranslateAnimation.setDuration(3000L);
            localTranslateAnimation.setAnimationListener(new Animation.AnimationListener()
            {
                public void onAnimationEnd(Animation paramAnonymous2Animation) {}

                public void onAnimationRepeat(Animation paramAnonymous2Animation) {}

                public void onAnimationStart(Animation paramAnonymous2Animation)
                {
                    mHandler.postDelayed(show, mDuration);
                    mTextView.setVisibility(GONE);
                }
            });
            startAnimation(localTranslateAnimation);
        }
    };

    private Handler mHandler = new Handler()
    {
        public void handleMessage(Message paramAnonymousMessage)
        {
            switch (paramAnonymousMessage.arg1)
            {
                default:
                    return;
                case 1:
                    animationOpen();
                    return;
            }
            //animationClose();
        }
    };

    Runnable show = new Runnable()
    {
        public void run()
        {
            TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, mTextHight, 0);
            localTranslateAnimation.setDuration(mDuration);
            localTranslateAnimation.setAnimationListener(new Animation.AnimationListener()
            {
                public void onAnimationEnd(Animation paramAnonymous2Animation)
                {
                    mHandler.postDelayed(dismiss, 3000L);
                }

                public void onAnimationRepeat(Animation animation) {}

                public void onAnimationStart(Animation animation)
                {
                    mIndex %= mTextArray.length;
                    mTextView.setText(mTextArray[mIndex]);
                    mTextView.setVisibility(VISIBLE);
                    mIndex += 1;
                }
            });
           startAnimation(localTranslateAnimation);
        }
    };

    public ScrollTextViewLayout(Context context) {
        super(context);
    }

    public ScrollTextViewLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mDuration = context.obtainStyledAttributes(attrs, R.styleable.scrollText).getInteger(R.styleable.scrollText_duration, 500);
    }

    private void animationClose()
    {
        post(this.dismiss);
    }

    private void animationOpen()
    {
        post(this.show);
    }

    public int getDuration()
    {
        return this.mDuration;
    }

    public String[] getTextArray()
    {
        return this.mTextArray;
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();
        this.mTextView = ((TextView)getChildAt(0));
    }

    @Override
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        this.mTextHight = this.mTextView.getHeight();
    }

    public void setDuration(int paramInt)
    {
        this.mDuration = paramInt;
    }

    public void setTextArray(String[] paramArrayOfString)
    {
        this.mTextArray = paramArrayOfString;
        if (this.mTextArray.length < 2)
        {
            this.mTextView.setText(this.mTextArray[0]);
            return;
        }
        this.mHandler.postDelayed(this.show, this.mDuration);
    }
}
