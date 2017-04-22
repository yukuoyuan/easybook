package cn.yky.easybook;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by yukuoyuan on 2017/4/22.
 */
public class EasyBookApplication extends Application {
    private static Context instance;
    private static Handler mainHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mainHandler = new Handler();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    /**
     * 获取全局上下文
     *
     * @return
     */
    public static Context getInstance() {
        return instance;
    }

    /**
     * 获取主线程
     */
    public static Handler getMainHandler() {
        return mainHandler;
    }
}
