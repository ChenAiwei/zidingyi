package com.example.hasee.zidingyi;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by hasee on 2016/5/8.
 */
public class AnimationUtils {
    public static int animationCount = 0;

    //开始动画
    public static void start(RelativeLayout rl, int startofset) {
        for (int i = 0; i < rl.getChildCount(); i++) {
            rl.getChildAt(i).setEnabled(true);
        }
        RotateAnimation animation = new RotateAnimation(-180, 0,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 1);
        animation.setDuration(500);
        //设置带延时效果的动画
        animation.setStartOffset(startofset);
        animation.setFillAfter(true);
        animation.setAnimationListener(new MyanimationListner());
        rl.startAnimation(animation);
    }

    //结束动画
    public static void close(RelativeLayout rl, int startofset) {
        for (int i = 0; i < rl.getChildCount(); i++) {
            rl.getChildAt(i).setEnabled(false);
        }
        RotateAnimation animation = new RotateAnimation(0, -180,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 1);
        animation.setDuration(500);
        //设置带延时效果的动画
        animation.setStartOffset(startofset);
        animation.setFillAfter(true);
        animation.setAnimationListener(new MyanimationListner());
        rl.startAnimation(animation);
    }

    static class MyanimationListner implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
            animationCount++;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            animationCount--;

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
