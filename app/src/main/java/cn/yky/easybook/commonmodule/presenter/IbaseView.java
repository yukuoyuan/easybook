package cn.yky.easybook.commonmodule.presenter;

/**
 * Created by yukuoyuan on 2017/4/22.
 */

public interface IbaseView {
    /**
     * 弹出Toast
     * @param msg
     */
    void showT(String msg);

    /**
     * 弹出进度条对话框
     * @param msg
     */
    void showL(String msg);

    /**
     * 关闭进度条对话框
     *
     */
    void closeL();
}
