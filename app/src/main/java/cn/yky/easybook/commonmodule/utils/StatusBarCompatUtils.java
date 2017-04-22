package cn.yky.easybook.commonmodule.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

/**
 * Created by yukuo on 2016/4/11.
 * 这是一个状态栏设置颜色的工具类(兼容4.4)
 */
public class StatusBarCompatUtils {
    /**
     * 设置状态栏的颜色
     *
     * @param activity
     * @param statusColor
     */
    public static void setStatusBarColor(Activity activity, int statusColor) {
        if (Build.VERSION.SDK_INT >= 21) {
            setLollipopStatusBarColors(activity, statusColor);
        } else if (Build.VERSION.SDK_INT >= 19) {
            setKitKatStatusBarColorss(activity, statusColor);
        }
    }

    @TargetApi(21)
    public static void setLollipopStatusBarColors(Activity activity, int statusColor) {
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(-2147483648);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(statusColor);
        }
        window.getDecorView().setSystemUiVisibility(0);
        ViewGroup mContentView = (ViewGroup) window.findViewById(16908290);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mChildView, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
                    return insets;
                }
            });
            ViewCompat.setFitsSystemWindows(mChildView, true);
            ViewCompat.requestApplyInsets(mChildView);
        }

    }

    @TargetApi(19)
    public static void setKitKatStatusBarColorss(Activity activity, int statusColor) {
        Window window = activity.getWindow();
        window.addFlags(67108864);
        ViewGroup mDecorView = (ViewGroup) window.getDecorView();
        ViewGroup mContentView = (ViewGroup) window.findViewById(16908290);
        View mContentChild = mContentView.getChildAt(0);
        if (mDecorView.getTag() != null && mDecorView.getTag() instanceof Integer) {
            View statusBarHeight1 = mDecorView.getChildAt(0);
            if (statusBarHeight1 != null) {
                statusBarHeight1.setBackgroundColor(statusColor);
            }

            if (mContentChild != null) {
                ViewCompat.setFitsSystemWindows(mContentChild, false);
            }

            int mStatusBarView1 = ((Integer) mDecorView.getTag()).intValue();
            if (mStatusBarView1 != 0) {
                addMarginTopToContentChild(mContentChild, ScreenUtils.getStatusHeight(activity));
                mDecorView.setTag(Integer.valueOf(0));
            }
        } else {
            int statusBarHeight = ScreenUtils.getStatusHeight(activity);
            if (mContentChild != null) {
                ViewCompat.setFitsSystemWindows(mContentChild, false);
                addMarginTopToContentChild(mContentChild, statusBarHeight);
            }

            View mStatusBarView = new View(activity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, statusBarHeight);
            layoutParams.gravity = 48;
            mStatusBarView.setLayoutParams(layoutParams);
            mStatusBarView.setBackgroundColor(statusColor);
            mDecorView.addView(mStatusBarView, 0);
            mDecorView.setTag(Integer.valueOf(0));
        }

    }

    private static void addMarginTopToContentChild(View mContentChild, int margin) {
        if (mContentChild != null) {
            if (mContentChild.getTag() == null || mContentChild.getTag() instanceof Integer && ((Integer) mContentChild.getTag()).intValue() != 0) {
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mContentChild.getLayoutParams();
                lp.topMargin += margin;
                mContentChild.setLayoutParams(lp);
                mContentChild.setTag(Integer.valueOf(0));
            }

        }
    }


}
