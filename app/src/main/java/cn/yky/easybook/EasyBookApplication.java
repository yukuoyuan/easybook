package cn.yky.easybook;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by yukuoyuan on 2017/4/22.
 */
public class EasyBookApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        recreate();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}
