package cn.yky.easybook.guidemodule.presenter;

import cn.yky.easybook.commonmodule.presenter.IbaseView;

/**
 * Created by yukuoyuan on 2017/4/22.
 */
public interface ISplashView extends IbaseView {
    /**
     * 跳转主界面
     */
    void startMainActivity();

    /**
     * 跳转引导界面
     */
    void startGuideActivity();

    /**
     * 跳转登录注册界面
     */
    void startLoginAndRegistActivity();

    /**
     * 加载动画效果
     */
    void loadAnimation();
}
