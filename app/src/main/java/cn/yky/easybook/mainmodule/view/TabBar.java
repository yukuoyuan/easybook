package cn.yky.easybook.mainmodule.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import cn.yky.easybook.R;

/**
 * Created by yukuoyuan on 2017/4/24.
 * 这是一个自定义的底部导航栏的按钮
 */

public class TabBar extends LinearLayout {

    private LinearLayout mContentView;

    public TabBar(Context context) {
        super(context);
        initView(context);
    }

    public TabBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    /**
     * 初始化界面的方法
     *
     * @param context
     */
    private void initView(Context context) {
        mContentView = (LinearLayout) View.inflate(context, R.layout.view_tabbar, null);
        //宽高
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        //距离父布局的距离
        lp.setMargins(0, 0, 0, 0);
        //设置布局的宽高的属性
        this.setLayoutParams(lp);
        //设置内容距离布局的边界的尺寸
        this.setPadding(0, 0, 0, 0);
        //添加内容布局并且设置宽是屏幕的宽.高为0
        addView(mContentView, new LayoutParams(LayoutParams.MATCH_PARENT, 0));
        //设置内容位于布局的下方
        setGravity(Gravity.BOTTOM);
        //测量
        measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

}
