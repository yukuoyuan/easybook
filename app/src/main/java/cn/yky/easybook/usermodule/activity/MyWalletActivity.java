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
 * 这是一个我的钱包的界面
 */
public class MyWalletActivity extends BaseActivity {
    @Bind(R.id.v_toolbar_back)
    View vToolbarBack;
    @Bind(R.id.iv_toolbar_back)
    ImageView ivToolbarBack;
    @Bind(R.id.tv_toolbar_back_title)
    TextView tvToolbarBackTitle;
    @Bind(R.id.tv_toolbar_back_right)
    TextView tvToolbarBackRight;
    @Bind(R.id.tv_mywallet_recharge)
    TextView tvMywalletRecharge;

    @Override
    protected void bindPresenter() {

    }

    @Override
    protected void initData(Bundle extras) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_mywallet;
    }

    @Override
    protected void initToolbar() {
        tvToolbarBackTitle.setText("钱包");
    }

    @OnClick({R.id.iv_toolbar_back, R.id.tv_mywallet_recharge})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_back:
                onBackPressed();
                break;
            case R.id.tv_mywallet_recharge:
                break;
        }
    }
}
