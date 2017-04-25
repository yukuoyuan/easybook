package cn.yky.easybook.messagemodule.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.activity.BaseActivity;

/**
 * Created by yukuoyuan on 2017/4/24.
 * 这是一个推送通知设置的界面
 */

public class NotificationSettingActivity extends BaseActivity {
    @Bind(R.id.swt_nt_setting_disturb)
    Switch swtNtSettingDisturb;
    @Bind(R.id.tv_toolbar_back_title)
    TextView tvToolbarBackTitle;

    @Override
    protected void bindPresenter() {

    }

    @Override
    protected void initData(Bundle extras) {
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_notificationsetting;
    }

    @Override
    protected void initToolbar() {
        tvToolbarBackTitle.setText("推送通知");

    }

    @OnClick({R.id.iv_toolbar_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_back:
                onBackPressed();
                break;

        }
    }


}
