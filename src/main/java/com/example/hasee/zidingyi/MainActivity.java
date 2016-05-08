package com.example.hasee.zidingyi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

//图标旋转的菜单
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_leve1_home;
    private ImageView iv_leve2_menu;
    private RelativeLayout leve1;
    private RelativeLayout leve2;
    private RelativeLayout leve3;
    private boolean isleve2 = true, isleve3 = true, ismenu = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initListener();

    }


    private void initUI() {
        setContentView(R.layout.activity_main);
        iv_leve1_home = (ImageView) findViewById(R.id.iv_leve1_home);
        iv_leve2_menu = (ImageView) findViewById(R.id.iv_leve2_menu);
        leve1 = (RelativeLayout) findViewById(R.id.leve1);
        leve2 = (RelativeLayout) findViewById(R.id.leve2);
        leve3 = (RelativeLayout) findViewById(R.id.leve3);
    }

    private void initListener() {
        iv_leve1_home.setOnClickListener(this);
        iv_leve2_menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_leve1_home:


                if (AnimationUtils.animationCount != 0) {
                    return;
                }
                int startofset = 0;
                if (isleve2) {

                    //同时关闭三级菜单
                    if (isleve3) {
                        AnimationUtils.close(leve3, startofset);
                        startofset += 200;
                        isleve3 = false;
                    }
                    //关闭
                    AnimationUtils.close(leve2, startofset);
                } else {
                    //显示
                    AnimationUtils.start(leve2, 0);
                }
                isleve2 = !isleve2;
                break;
            case R.id.iv_leve2_menu:
                if (AnimationUtils.animationCount != 0) {
                    return;
                }
                if (isleve3) {
                    //关闭
                    AnimationUtils.close(leve3, 0);
                } else {
                    //显示
                    AnimationUtils.start(leve3, 0);
                }
                isleve3 = !isleve3;
                break;
        }
    }
    //点击菜单按键把菜单动画全部关闭或隐藏

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            if (ismenu) {
                int startofset = 0;
                if (isleve3) {
                    AnimationUtils.close(leve3, startofset);
                    startofset += 200;
                }
                if (isleve2) {
                    AnimationUtils.close(leve2, startofset);
                    startofset += 200;
                }
                AnimationUtils.close(leve1, startofset);
                ismenu = false;
            } else {
                //显示所有菜单
                int startofset = 0;
                AnimationUtils.start(leve1, startofset);
                startofset += 200;
                AnimationUtils.start(leve2, startofset);
                startofset += 200;
                AnimationUtils.start(leve3, startofset);
                ismenu = true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
