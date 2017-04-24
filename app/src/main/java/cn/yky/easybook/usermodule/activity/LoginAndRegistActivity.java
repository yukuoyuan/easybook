package cn.yky.easybook.usermodule.activity;

import android.os.Bundle;

import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.activity.BaseActivity;
import cn.yky.easybook.mainmodule.activity.MainActivity;

/**
 * Created by yukuoyuan on 2017/4/22.
 * 登录和注册界面
 */

public class LoginAndRegistActivity extends BaseActivity {
    @Override
    protected void bindPresenter() {

    }

    @Override
    protected void initData(Bundle extras) {
        intent2Activity(MainActivity.class);
        finish();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_login_regist;
    }

    @Override
    protected void initToolbar() {

    }
}
