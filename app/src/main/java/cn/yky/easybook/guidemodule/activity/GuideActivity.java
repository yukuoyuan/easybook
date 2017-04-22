package cn.yky.easybook.guidemodule.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.activity.BaseActivity;
import cn.yky.easybook.commonmodule.manager.UserManager;
import cn.yky.easybook.guidemodule.adapter.PagerAdapter;
import cn.yky.easybook.guidemodule.fragment.FirstGuideFragment;
import cn.yky.easybook.guidemodule.fragment.FourGuideFragment;
import cn.yky.easybook.guidemodule.fragment.SecondGuideFragment;
import cn.yky.easybook.guidemodule.fragment.ThirdGuideFragment;
import cn.yky.easybook.guidemodule.presenter.IGuideView;
import cn.yky.easybook.usermodule.activity.LoginAndRegistActivity;

/**
 * Created by yukuoyuan on 2017/4/22.
 * 这是一个引导页面
 */
public class GuideActivity extends BaseActivity implements IGuideView {
    @Bind(R.id.vp_guide)
    ViewPager vpGuide;
    @Bind(R.id.bt_guide_jump)
    Button btGuideJump;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void bindPresenter() {

    }

    @Override
    protected void initData(Bundle extras) {
        fragments.add(new FirstGuideFragment());
        fragments.add(new SecondGuideFragment());
        fragments.add(new ThirdGuideFragment());
        fragments.add(new FourGuideFragment());
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        vpGuide.setAdapter(pagerAdapter);
        vpGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 3) {
                    btGuideJump.setVisibility(View.VISIBLE);
                } else {
                    btGuideJump.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    public void showT(String msg) {

    }

    @Override
    public void showL(String msg) {

    }

    @Override
    public void closeL() {

    }

    @OnClick({R.id.bt_guide_jump})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_guide_jump:
                UserManager.setIsFirst(true);
                startLoginAndRegistActivity();
                break;
        }
    }

    @Override
    public void startLoginAndRegistActivity() {
        intent2Activity(LoginAndRegistActivity.class);
    }
}
