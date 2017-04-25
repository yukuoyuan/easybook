package cn.yky.easybook.usermodule.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.OnClick;
import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.fragment.BaseFragment;
import cn.yky.easybook.commonmodule.glide.GlideCircleTransform;

/**
 * Created by yukuoyuan on 2017/4/25.
 * 这是一个我的界面
 */
public class MineFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    @Bind(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @Bind(R.id.iv_toolbar_right_first)
    ImageView ivToolbarRightFirst;
    @Bind(R.id.iv_toolbar_right)
    ImageView ivToolbarRight;
    @Bind(R.id.iv_mine_avarar)
    ImageView ivMineAvarar;
    @Bind(R.id.iv_mine_name)
    TextView ivMineName;
    @Bind(R.id.sc_mine_is_night)
    SwitchCompat scMineIsNight;

    @Override
    public void initdata(Bundle arguments) {
        scMineIsNight.setOnCheckedChangeListener(this);
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void bindPresenter() {

    }

    @Override
    protected void initToolbar() {
        tvToolbarTitle.setText(R.string.tab_bar_mine);
        Glide.with(getActivity()).load(R.drawable.default_avatar).transform(new GlideCircleTransform(getActivity())).into(ivMineAvarar);
    }


    @OnClick({R.id.iv_toolbar_right_first, R.id.iv_toolbar_right, R.id.rl_mine_info_edit, R.id.ll_mine_article_public, R.id.ll_mine_article_private, R.id.ll_mine_article_mark, R.id.ll_mine_article_like, R.id.ll_mine_article_topic, R.id.ll_mine_article_book, R.id.ll_mine_wallet, R.id.ll_mine_browse_record, R.id.ll_mine_share_app, R.id.ll_mine_feed_back, R.id.ll_mine_to_app_score})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_right_first:
                break;
            case R.id.iv_toolbar_right:
                break;
            case R.id.rl_mine_info_edit:
                break;
            case R.id.ll_mine_article_public:
                break;
            case R.id.ll_mine_article_private:
                break;
            case R.id.ll_mine_article_mark:
                break;
            case R.id.ll_mine_article_like:
                break;
            case R.id.ll_mine_article_topic:
                break;
            case R.id.ll_mine_article_book:
                break;
            case R.id.ll_mine_wallet:
                break;
            case R.id.ll_mine_browse_record:
                break;
            case R.id.ll_mine_share_app:
                break;
            case R.id.ll_mine_feed_back:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                getActivity().recreate();
                break;
            case R.id.ll_mine_to_app_score:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                getActivity().recreate();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {

        } else {
        }
    }
}
