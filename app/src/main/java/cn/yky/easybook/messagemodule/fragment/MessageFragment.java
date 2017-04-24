package cn.yky.easybook.messagemodule.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.fragment.BaseFragment;

/**
 * Created by yukuoyuan on 2017/4/24.
 * 这是一个我的消息列表的界面
 */

public class MessageFragment extends BaseFragment {

    @Bind(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;

    @Override
    public void initdata(Bundle arguments) {


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

    @OnClick({R.id.iv_toolbar_right, R.id.ll_msg_comment, R.id.ll_msg_message, R.id.ll_msg_ask, R.id.ll_msg_like_star, R.id.ll_msg_like_follow, R.id.ll_msg_like_appreciate, R.id.ll_msg_like_othertip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_right:
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
//
//    @OnClick({R.id.tv_toolbar_title, R.id.bt_test})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.tv_toolbar_title:
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                getActivity().recreate();
//                break;
//            case R.id.bt_test:
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                getActivity().recreate();
//                break;
//        }
//    }
}
