package com.learn.customtoast;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ant.liao.GifView;

/**
 * Created by Administrator on 2016/11/15 0015.
 */

public class CustomToast extends Toast{

    private Context context;
    public CustomToast(Context context) {
        super(context);
    }

    public static CustomToast makeText(Context context, int iconResId, CharSequence topText, CharSequence bottomText, CharSequence accountText,
                                     int duration) {
        CustomToast result = new CustomToast(context);

        LayoutInflater inflate = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.toast_view, null);
        v.getBackground().setAlpha(220);
        TextView top_tv = (TextView) v.findViewById(R.id.tips_msg);
        TextView bottom_tv = (TextView) v.findViewById(R.id.bottom_msg);
        TextView account_tv = (TextView) v.findViewById(R.id.account);
        GifView tip_icon = (GifView) v.findViewById(R.id.tips_icon);
        top_tv.setText(topText);
        bottom_tv.setText(bottomText);
        account_tv.setText(accountText);
        tip_icon.setGifImage(iconResId);
        tip_icon.setShowDimension(80,80);
        result.setView(v);
        // setGravity方法用于设置位置，此处为垂直居中
        result.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        result.setDuration(duration);

        return result;
    }

    public static CustomToast makeText(Context context, int resId, int duration) {
        return (CustomToast) makeText(context, context.getResources().getText(resId),
                duration);
    }

    public void setIcon(int iconResId) {
        if (getView() == null) {
            throw new RuntimeException(
                    "This Toast was not created with Toast.makeText()");
        }
        ImageView iv = (ImageView) getView().findViewById(R.id.tips_icon);
        if (iv == null) {
            throw new RuntimeException(
                    "This Toast was not created with Toast.makeText()");
        }
        iv.setImageResource(iconResId);
    }
}
