package cn.yky.easybook.guidemodule.fragment;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.fragment.BaseFragment;

/**
 * Created by yukoyuan on 16/7/5.
 * 这是第三个引导界面
 */
public class ThirdGuideFragment extends BaseFragment {

    @Bind(R.id.iv_third_guide)
    ImageView ivThirdGuide;

    @Override
    public void initdata(Bundle arguments) {
        Glide.with(getActivity()).load(R.drawable.bg_guide_03).centerCrop().into(ivThirdGuide);

    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_thirdguide;
    }

    @Override
    protected void bindPresenter() {

    }

    @Override
    protected void initToolbar() {

    }

}
