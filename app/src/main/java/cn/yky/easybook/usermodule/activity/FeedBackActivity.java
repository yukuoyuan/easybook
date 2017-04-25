package cn.yky.easybook.usermodule.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.activity.BaseActivity;

/**
 * Created by yukuoyuan on 2017/4/25.
 * 这是一个意见反馈的界面
 */
public class FeedBackActivity extends BaseActivity {
    @Bind(R.id.iv_toolbar_back)
    ImageView ivToolbarBack;
    @Bind(R.id.tv_toolbar_back_title)
    TextView tvToolbarBackTitle;
    @Bind(R.id.tv_toolbar_back_right)
    TextView tvToolbarBackRight;

    @Override
    protected void bindPresenter() {

    }

    @Override
    protected void initData(Bundle extras) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initToolbar() {
        tvToolbarBackRight.setVisibility(View.VISIBLE);
        tvToolbarBackTitle.setText(R.string.feed_back);
    }

    @OnClick({R.id.iv_toolbar_back, R.id.tv_toolbar_back_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_back:
                onBackPressed();
                break;
            case R.id.tv_toolbar_back_right:
                onBackPressed();
                break;
        }
    }
}
