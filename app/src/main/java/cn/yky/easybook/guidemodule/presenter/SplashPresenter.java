package cn.yky.easybook.guidemodule.presenter;


import cn.yky.easybook.commonmodule.manager.UserManager;
import cn.yky.easybook.guidemodule.activity.SplashActivity;

/**
 * Created by yukuoyuan on 2017/4/22.
 * 这是一个过度界面的逻辑层
 */
public class SplashPresenter {
    private SplashActivity splashActivity;
    private ISplashView iSplashView;

    public SplashPresenter(SplashActivity splashActivity, ISplashView iSplashView) {
        this.splashActivity = splashActivity;
        this.iSplashView = iSplashView;
    }

    /**
     * 跳转逻辑
     */
    public void jump() {
        //是否是第一次打开app
        if (UserManager.isFirst()) {
            if (UserManager.isLogin()) {
                iSplashView.startMainActivity();
            } else {
                iSplashView.startLoginAndRegistActivity();
            }
        } else {
            iSplashView.startGuideActivity();
        }
    }
}
