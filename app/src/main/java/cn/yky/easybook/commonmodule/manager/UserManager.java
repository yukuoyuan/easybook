package cn.yky.easybook.commonmodule.manager;

import java.util.Map;

import cn.yky.easybook.EasyBookApplication;
import cn.yky.easybook.commonmodule.config.Constant;
import cn.yky.easybook.commonmodule.utils.L;
import cn.yky.easybook.commonmodule.utils.SPUtil;

/**
 * Created by yukuo on 2016/4/19.
 * 这是一个用户管理类
 */
public class UserManager {
    /**
     * 清除所有数据
     */
    public static void clearAllInfo() {
        SPUtil.clear(EasyBookApplication.getInstance());
    }

    /**
     * 获取用户的手机号
     *
     * @return 返回的手机号
     */
    public static String getUserPhone() {
        return SPUtil.getString(EasyBookApplication.getInstance(), Constant.USER_PHONE, "");
    }

    /**
     * 获取登录状态
     */
    public static boolean isLogin() {
        return SPUtil.getBoolean(EasyBookApplication.getInstance(), Constant.ISLOGIN, false);
    }

    /**
     * 设置登录状态
     */
    public static void setIsLogin(boolean islogin) {
        SPUtil.putBoolean(EasyBookApplication.getInstance(), Constant.ISLOGIN, islogin);
    }

    /**
     * 打印所有SP信息
     */
    public static void showAll() {
        Map<String, ?> map = SPUtil.getAll(EasyBookApplication.getInstance());
        for (String key : map.keySet()) {
            L.d("WJ", key + ":" + map.get(key));
        }
    }

    /**
     * 这是一个设置是否是第一次打开app界面
     *
     * @param isFirst
     */
    public static void setIsFirst(boolean isFirst) {
        SPUtil.putBoolean(EasyBookApplication.getInstance(), Constant.ISFIRST, isFirst);
    }

    /**
     * 这是一个获取是否是第一次打开app界面
     */
    public static boolean isFirst() {
        return SPUtil.getBoolean(EasyBookApplication.getInstance(), Constant.ISFIRST, false);
    }

    /**
     * 是否是夜景模式
     *
     * @return
     */
    public static boolean isNight() {
        return SPUtil.getBoolean(EasyBookApplication.getInstance(), Constant.ISNIGHT, false);

    }

    /**
     * 设置是否是夜景模式
     *
     * @param isNight
     */
    public static void setisNight(boolean isNight) {
        SPUtil.putBoolean(EasyBookApplication.getInstance(), Constant.ISNIGHT, isNight);
    }
}
