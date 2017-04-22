package cn.yky.easybook.commonmodule.utils;

import android.app.Activity;

import java.util.Stack;

import cn.yky.easybook.commonmodule.activity.BaseActivity;

/**
 * Created by yukuo on 2016/5/11.
 * 这是一个管理所有activity的工具类
 */
public class AppStackUtil {
    private static Stack<Activity> activityStack;
    private static final AppStackUtil instance = new AppStackUtil();

    private AppStackUtil() {
    }

    public static AppStackUtil getInstance() {
        return instance;
    }

    /**
     * 获取当前Activity栈中元素个数
     */
    public int getCount() {
        return activityStack.size();
    }

    /**
     * 添加Activity到栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（栈顶Activity）
     */
    public Activity topActivity() {
        if (activityStack == null) {
            throw new NullPointerException(
                    "Activity stack is Null,your Activity must extend KJActivity");
        }
        if (activityStack.isEmpty()) {
            return null;
        }
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 获取当前Activity（栈顶Activity） 没有找到则返回null
     */
    public Activity findActivity(Class<?> cls) {
        Activity activity = null;
        for (Activity aty : activityStack) {
            if (aty.getClass().equals(cls)) {
                activity = aty;
                break;
            }
        }
        return (Activity) activity;
    }

    /**
     * 结束当前Activity（栈顶Activity）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity((Activity) activity);
    }

    /**
     * 结束指定的Activity(重载)
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定的Activity(重载)
     */
    public void finishActivity(Class<?> cls) {
        if (activityStack != null) {
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    finishActivity((Activity) activity);
                }
            }
        }
    }

    /**
     * 关闭除了指定activity以外的全部activity 如果cls不存在于栈中，则栈全部清空
     *
     * @param cls
     */
    public void finishOthersActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (!(activity.getClass().equals(cls))) {
                finishActivity((Activity) activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                ((Activity) activityStack.get(i)).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 结束所有Activity
     */
    public void finishAllExceptionMain() {
        while (activityStack.size() != 1) {
            Activity pop = activityStack.pop();
            pop.finish();
        }
    }

    /**
     * 应用程序退出
     */
    public void appExit() {
        try {
            finishAllActivity();
            Runtime.getRuntime().exit(0);
        } catch (Exception e) {
            Runtime.getRuntime().exit(-1);
        }
    }

    public boolean isHaveActivity(Class activity) {
        int size = activityStack.size();
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {

            if (activity.equals(activityStack.get(i).getClass())) {
                return true;
            }
        }
        return false;
    }

    public void removeActivity(BaseActivity activity) {
        if (activityStack != null) {
            activityStack.remove(activity);
        }

    }
}
