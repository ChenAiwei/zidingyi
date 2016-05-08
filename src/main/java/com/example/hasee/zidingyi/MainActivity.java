package com.example.hasee.zidingyi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private boolean isleve2 = true, isleve3 = true;

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
                if (isleve2) {
                    //关闭
                    AnimationUtils.close(leve2);
                } else {
                    //显示
                    AnimationUtils.start(leve2);
                }
                isleve2 = !isleve2;
                break;
            case R.id.iv_leve2_menu:
                if (isleve3) {
                    //关闭
                    AnimationUtils.close(leve3);
                } else {
                    //显示
                    AnimationUtils.start(leve3);
                }
                isleve3 = !isleve3;
                break;
        }
    }
}
