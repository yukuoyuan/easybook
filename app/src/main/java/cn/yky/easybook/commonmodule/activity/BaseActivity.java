package cn.yky.easybook.commonmodule.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.utils.AppStackUtil;
import cn.yky.easybook.commonmodule.utils.T;
import cn.yky.easybook.commonmodule.views.IosProgressDialog;
import cn.yky.easybook.guidemodule.activity.SplashActivity;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by yukuoyuan on 2017/2/25.
 * 这是一个基础的Activity
 */
public abstract class BaseActivity extends AppCompatActivity {

    private IosProgressDialog iosProgressDialog;
    private FrameLayout contentRoot;
    private final int VIEW_LOADING_INDEX = 0, VIEW_CONTENT_INDEX = 1;//布局层级
    private AppStackUtil appStackUtil;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //填充器
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        setContentView(createLayout(inflater));
        mContext = this;
        ButterKnife.bind(this);
        initToolbar();
        bindPresenter();
        initData(getIntent().getExtras());
        appStackUtil = AppStackUtil.getInstance();
        if (!this.getClass().equals(SplashActivity.class)) {
            AppStackUtil.getInstance().addActivity(this);
        }
    }

    public void showLoad(Context context, String message) {
        if (context != null) {
            iosProgressDialog = new IosProgressDialog(context, message);
            iosProgressDialog.show();
        }
    }

    public void closeLoad() {
        if (iosProgressDialog != null && iosProgressDialog.isShowing()) {
            iosProgressDialog.dismiss();
        }
    }

    private FrameLayout createLayout(LayoutInflater inflater) {
        contentRoot = new FrameLayout(this);//根布局
        //跟布局的宽高
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        contentRoot.setLayoutParams(layoutParams);
        // 进度条布局
        View loading = inflater.inflate(getLoadingLayout(), null, false);
        contentRoot.addView(loading, VIEW_LOADING_INDEX, layoutParams);
        loading.setVisibility(GONE);
        // 主要内容布局
        View content = inflater.inflate(getContentLayout(), null, false);
        contentRoot.addView(content, VIEW_CONTENT_INDEX, layoutParams);
        return contentRoot;
    }

    /**
     * 这是一个绑定业务层的方法
     */
    protected abstract void bindPresenter();

    /**
     * 这是一个初始化界面数据的方法
     *
     * @param extras
     */
    protected abstract void initData(Bundle extras);

    /**
     * 这是一个获取页面布局的方法
     *
     * @return 返回一个layoutId
     */
    public abstract int getContentLayout();

    /**
     * 初始化头布局的方法
     */
    protected abstract void initToolbar();
    /**
     * 界面跳转
     *
     * @param tarActivity
     */
    protected void intent2Activity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(mContext, tarActivity);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        //关闭对话框
        closeLoad();
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    /**
     * 展示内容布局
     */
    protected void showContentLayout() {
        changeShowAnimation(VIEW_LOADING_INDEX, GONE);
        changeShowAnimation(VIEW_CONTENT_INDEX, VISIBLE);
    }

    /**
     * 展示加载布局
     */
    protected void showLoadingLayout() {
        changeShowAnimation(VIEW_CONTENT_INDEX, GONE);
        changeShowAnimation(VIEW_LOADING_INDEX, VISIBLE);
    }

    /**
     * 布局动画切换
     *
     * @param visible
     */
    private void changeShowAnimation(int childrenIndex, int visible) {
        int animId = 0;
        View view = contentRoot.getChildAt(childrenIndex);
        switch (visible) {
            case View.VISIBLE:
                if (view.getVisibility() == View.VISIBLE) {
                    return;
                }
                view.setVisibility(View.VISIBLE);
                animId = android.R.anim.fade_in;
                break;
            case View.GONE:
                if (view.getVisibility() == View.GONE) {
                    return;
                }
                view.setVisibility(View.GONE);
                animId = android.R.anim.fade_out;
                break;
        }
        Animation anim = AnimationUtils.loadAnimation(this, animId);
        anim.setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime));
        view.startAnimation(anim);
    }

    public void showToast(Context context, String message) {
        T.showLong(context, message);
    }

    /**
     * 获取一个加载布局
     *
     * @return
     */
    public int getLoadingLayout() {
        return R.layout.dialog_iosprogress;
    }

}
