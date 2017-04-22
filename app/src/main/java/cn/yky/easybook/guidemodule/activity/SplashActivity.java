package cn.yky.easybook.guidemodule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.activity.BaseActivity;
import cn.yky.easybook.guidemodule.presenter.ISplashView;
import cn.yky.easybook.guidemodule.presenter.SplashPresenter;

/**
 * 这是一个过度界面
 */
public class SplashActivity extends BaseActivity implements ISplashView {


    @Bind(R.id.iv_splash)
    ImageView ivSplash;
    private SplashPresenter splashPresenter;

    @Override
    protected void bindPresenter() {
        splashPresenter = new SplashPresenter(this, this);
    }

    @Override
    protected void initData(Bundle extras) {
        Glide.with(this).load(R.drawable.bg_splash).centerCrop().into(ivSplash);
        loadAnimation();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    public void showT(String msg) {

    }

    @Override
    public void showL(String msg) {

    }

    @Override
    public void closeL() {

    }

    @Override
    public void startMainActivity() {

    }

    @Override
    public void startGuideActivity() {
        Intent intent = new Intent(this, GuideActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void startLoginAndRegistActivity() {

    }

    @Override
    public void loadAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(2500l);
        ivSplash.setAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //当动画加载完毕之后
                splashPresenter.jump();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
