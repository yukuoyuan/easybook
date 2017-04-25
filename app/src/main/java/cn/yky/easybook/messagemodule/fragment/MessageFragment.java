package cn.yky.easybook.messagemodule.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.fragment.BaseFragment;
import cn.yky.easybook.messagemodule.activity.NotificationSettingActivity;

/**
 * Created by yukuoyuan on 2017/4/24.
 * 这是一个我的消息列表的界面
 */

public class MessageFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @Bind(R.id.srl_msg)
    SwipeRefreshLayout srlMsg;
    private Intent intent;

    @Override
    public void initdata(Bundle arguments) {
        srlMsg.setColorSchemeColors(getActivity().getResources().getColor(R.color.c_FEC3C0));
        srlMsg.setOnRefreshListener(this);
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_message;

    }

    @Override
    protected void bindPresenter() {

    }

    @Override
    protected void initToolbar() {

    }

    @OnClick({R.id.iv_toolbar_right, R.id.iv_toolbar_right_first, R.id.ll_msg_comment, R.id.ll_msg_message, R.id.ll_msg_ask, R.id.ll_msg_like_star, R.id.ll_msg_like_follow, R.id.ll_msg_like_appreciate, R.id.ll_msg_like_othertip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_right:
                /**
                 * 搜索界面
                 */
                break;
            case R.id.iv_toolbar_right_first:
                /**
                 * 推送设置界面
                 *
                 */
                intent = new Intent(getActivity(), NotificationSettingActivity.class);
                getActivity().startActivity(intent);
                break;

            case R.id.ll_msg_comment:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                getActivity().recreate();
                break;
            case R.id.ll_msg_message:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                getActivity().recreate();
                break;
            case R.id.ll_msg_ask:
                break;
            case R.id.ll_msg_like_star:
                break;
            case R.id.ll_msg_like_follow:
                break;
            case R.id.ll_msg_like_appreciate:
                break;
            case R.id.ll_msg_like_othertip:
                break;
        }
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                srlMsg.setRefreshing(false);
            }
        }, 2000);
    }
}
