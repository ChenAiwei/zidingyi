package com.example.hasee.zidingyi;

import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by hasee on 2016/5/8.
 */
public class AnimationUtils {
    //开始动画
    public  static void start(RelativeLayout rl){
       RotateAnimation animation=new RotateAnimation(-180,0,
               RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,1);
        animation.setDuration(500);
        animation.setFillAfter(true);

        rl.startAnimation(animation);
    }
    //结束动画
    public static void close(RelativeLayout rl){
        RotateAnimation animation=new RotateAnimation(0,-180,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,1);
        animation.setDuration(500);
        animation.setFillAfter(true);

        rl.startAnimation(animation);
    }
}
