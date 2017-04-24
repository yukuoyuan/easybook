package cn.yky.easybook.mainmodule.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.yky.easybook.R;

/**
 * Created by yukuoyuan on 2017/4/24.
 * 这是一个自定义的底部导航栏的按钮
 */

public class TabBar extends LinearLayout implements View.OnClickListener {

    private LinearLayout mContentView;
    private LinearLayout ll_tab_bar_home;
    private LinearLayout ll_tab_bar_find;
    private LinearLayout ll_tab_bar_write_article;
    private LinearLayout ll_tab_bar_msg;
    private LinearLayout ll_tab_bar_mine;
    private TextView tv_tab_bar_home;
    private TextView tv_tab_bar_find;
    private TextView tv_tab_bar_write_article;
    private TextView tv_tab_bar_msg;
    private TextView tv_tab_bar_mine;
    private OnTabCheckListener onTabCheckListener;

    public interface OnTabCheckListener {
        void onTabChecked(int position);
    }

    public void setTabCheckedListener(OnTabCheckListener onTabCheckListener) {
        this.onTabCheckListener = onTabCheckListener;
    }

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
        addView(mContentView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        //设置内容位于布局的下方
        setGravity(Gravity.BOTTOM);
        //测量
        measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        findview();
        initListener();

    }

    /**
     * 设置监听
     */
    private void initListener() {
        ll_tab_bar_home.setOnClickListener(this);
        ll_tab_bar_find.setOnClickListener(this);
        ll_tab_bar_write_article.setOnClickListener(this);
        ll_tab_bar_msg.setOnClickListener(this);
        ll_tab_bar_mine.setOnClickListener(this);
    }

    /**
     * 初始化控件
     */
    private void findview() {
        ll_tab_bar_home = (LinearLayout) mContentView.findViewById(R.id.ll_tab_bar_home);
        ll_tab_bar_find = (LinearLayout) mContentView.findViewById(R.id.ll_tab_bar_find);
        ll_tab_bar_write_article = (LinearLayout) mContentView.findViewById(R.id.ll_tab_bar_write_article);
        ll_tab_bar_msg = (LinearLayout) mContentView.findViewById(R.id.ll_tab_bar_msg);
        ll_tab_bar_mine = (LinearLayout) mContentView.findViewById(R.id.ll_tab_bar_mine);

        tv_tab_bar_home = (TextView) mContentView.findViewById(R.id.tv_tab_bar_home);
        tv_tab_bar_find = (TextView) mContentView.findViewById(R.id.tv_tab_bar_find);
        tv_tab_bar_write_article = (TextView) mContentView.findViewById(R.id.tv_tab_bar_write_article);
        tv_tab_bar_msg = (TextView) mContentView.findViewById(R.id.tv_tab_bar_msg);
        tv_tab_bar_mine = (TextView) mContentView.findViewById(R.id.tv_tab_bar_mine);
    }

    @Override
    public void onClick(View v) {
        clearAllStatus();
        switch (v.getId()) {
            case R.id.ll_tab_bar_home:
                tv_tab_bar_home.setEnabled(true);
                setCheckedListener(0);
                break;
            case R.id.ll_tab_bar_find:
                tv_tab_bar_find.setEnabled(true);
                setCheckedListener(1);
                break;
            case R.id.ll_tab_bar_write_article:
                tv_tab_bar_write_article.setEnabled(true);
                setCheckedListener(2);
                break;
            case R.id.ll_tab_bar_msg:
                tv_tab_bar_msg.setEnabled(true);
                setCheckedListener(3);
                break;
            case R.id.ll_tab_bar_mine:
                tv_tab_bar_mine.setEnabled(true);
                setCheckedListener(4);
                break;

        }
    }

    /**
     * 设置按钮的选中状态
     */
    private void setCheckedListener(int position) {
        if (onTabCheckListener != null) {
            onTabCheckListener.onTabChecked(position);
        }
    }

    /**
     * 清除所有的状态
     */
    private void clearAllStatus() {
        tv_tab_bar_home.setEnabled(false);
        tv_tab_bar_find.setEnabled(false);
        tv_tab_bar_write_article.setEnabled(false);
        tv_tab_bar_msg.setEnabled(false);
        tv_tab_bar_mine.setEnabled(false);
    }

    /**
     * 设置某一个按钮的选中状态
     *
     * @param tabbatPosition 按钮的位置
     */
    public void setTabBarEnabled(int tabbatPosition) {
        clearAllStatus();
        switch (tabbatPosition) {
            case 0:
                tv_tab_bar_home.setEnabled(true);
                break;
            case 1:
                tv_tab_bar_find.setEnabled(true);
                break;
            case 2:
                tv_tab_bar_write_article.setEnabled(true);
                break;
            case 3:
                tv_tab_bar_msg.setEnabled(true);
                break;
            case 4:
                tv_tab_bar_mine.setEnabled(true);
                break;

        }
    }
}
