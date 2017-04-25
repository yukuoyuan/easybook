package cn.yky.easybook.mainmodule.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.activity.BaseActivity;
import cn.yky.easybook.guidemodule.adapter.PagerAdapter;
import cn.yky.easybook.guidemodule.fragment.FirstGuideFragment;
import cn.yky.easybook.guidemodule.fragment.SecondGuideFragment;
import cn.yky.easybook.guidemodule.fragment.ThirdGuideFragment;
import cn.yky.easybook.mainmodule.view.TabBar;
import cn.yky.easybook.messagemodule.fragment.MessageFragment;
import cn.yky.easybook.usermodule.fragment.MineFragment;

/**
 * Created by yukuoyuan on 2017/4/24.
 * 这是一个主界面
 */
public class MainActivity extends BaseActivity {
    @Bind(R.id.vp_main)
    ViewPager vpMain;
    @Bind(R.id.tab_main)
    TabBar tabMain;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void bindPresenter() {

    }

    @Override
    protected void initData(Bundle extras) {
        fragments.add(new FirstGuideFragment());
        fragments.add(new SecondGuideFragment());
        fragments.add(new ThirdGuideFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MineFragment());
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        vpMain.setAdapter(pagerAdapter);
        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                tabMain.setTabBarEnabled(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabMain.setTabCheckedListener(new TabBar.OnTabCheckListener() {
            @Override
            public void onTabChecked(int position) {
                vpMain.setCurrentItem(position, false);
            }
        });
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar() {

    }

}
