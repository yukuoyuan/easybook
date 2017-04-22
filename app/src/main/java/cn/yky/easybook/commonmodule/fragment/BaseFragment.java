package cn.yky.easybook.commonmodule.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import cn.yky.easybook.R;
import cn.yky.easybook.commonmodule.utils.T;
import cn.yky.easybook.commonmodule.views.IosProgressDialog;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by yukuo on 2016/4/19.
 * 这是一个基础的碎片界面
 */
public abstract class BaseFragment extends Fragment {

    private FrameLayout contentRoot; //页面跟布局
    private int contentRootColor;//页面跟布局背景

    private final int VIEW_LOADING_INDEX = 0, VIEW_CONTENT_INDEX = 1;//布局层级
    private IosProgressDialog iosProgressDialog;

    /**
     * 这是一个初始化数据的方法
     */
    public abstract void initdata(Bundle arguments);

    /**
     * 这是一个获取布局文件资源的方法
     *
     * @return
     */
    public abstract int getContentLayout();

    /**
     * 这是一个绑定业务层的方法
     */
    protected abstract void bindPresenter();

    /**
     * 初始化头布局的方法
     */
    protected abstract void initToolbar();

    public void showLoad(Context context, String message) {
        if (iosProgressDialog == null) {
            iosProgressDialog = new IosProgressDialog(context, message);
        }
        iosProgressDialog.show();
    }

    public void closeLoad() {
        if (iosProgressDialog != null && iosProgressDialog.isShowing()) {
            iosProgressDialog.dismiss();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = createLayout(inflater);
        ButterKnife.bind(this, view);
        return view;
    }

    private FrameLayout createLayout(LayoutInflater inflater) {
        contentRoot = new FrameLayout(getActivity());//根布局
        //跟布局的宽高
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        contentRoot.setLayoutParams(layoutParams);
        // 进度条布局
        View loading = inflater.inflate(getLoadingLayout(), null, false);
        contentRoot.addView(loading, VIEW_LOADING_INDEX, layoutParams);
        loading.setVisibility(GONE);
        // 主要内容布局
        View content = inflater.inflate(getContentLayout(), null, false);
        contentRoot.addView(content, VIEW_CONTENT_INDEX, layoutParams);
        return contentRoot;
    }

    // 功能
    protected void layoutContent() {
        changeShowAnimation(VIEW_LOADING_INDEX, GONE);
        changeShowAnimation(VIEW_CONTENT_INDEX, VISIBLE);
    }

    protected void layoutLoading() {
        changeShowAnimation(VIEW_CONTENT_INDEX, GONE);
        changeShowAnimation(VIEW_LOADING_INDEX, VISIBLE);
    }

    /**
     * 动画切换
     *
     * @param visible
     */
    private void changeShowAnimation(int childrenIndex, int visible) {
        int animId = 0;
        View view = contentRoot.getChildAt(childrenIndex);

        switch (visible) {
            case View.VISIBLE:
                if (view.getVisibility() == View.VISIBLE) {
                    return;
                }
                view.setVisibility(View.VISIBLE);
                animId = android.R.anim.fade_in;
                break;
            case View.GONE:
                if (view.getVisibility() == View.GONE) {
                    return;
                }
                view.setVisibility(View.GONE);
                animId = android.R.anim.fade_out;
                break;
        }

        Animation anim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), animId);
        anim.setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime));
        view.startAnimation(anim);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initToolbar();
        bindPresenter();
        initdata(getArguments());
    }

    public void showToast(Context context, String text) {
        T.show(context, text, 0);
    }

    /**
     * 加载页面
     *
     * @return
     */
    protected int getLoadingLayout() {
        return R.layout.dialog_iosprogress;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
