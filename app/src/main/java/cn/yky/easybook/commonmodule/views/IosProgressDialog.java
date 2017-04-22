package cn.yky.easybook.commonmodule.views;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import cn.yky.easybook.R;

/**
 * Created by yukuo on 2016/4/29.
 */
public class IosProgressDialog extends Dialog {
    public IosProgressDialog(Context context, String message) {
        this(context, R.style.DialogStyle, message);
    }

    public IosProgressDialog(Context context, int theme, String message) {
        super(context, theme);
        //设置对话框的显示view
        View view = View.inflate(context, R.layout.dialog_iosprogress, null);
        TextView tv_popuwindow_progress = (TextView) view.findViewById(R.id.tv_popuwindow_progress);
        tv_popuwindow_progress.setText(message);
        this.setContentView(view);
        this.setCancelable(true);
        //设置窗口居中
        this.getWindow().getAttributes().gravity = Gravity.CENTER;
    }
}