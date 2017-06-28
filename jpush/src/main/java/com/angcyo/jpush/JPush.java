package com.angcyo.jpush;

import android.app.Application;
import android.app.Notification;
import android.util.Log;

import java.util.Set;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/06/28 09:22
 * 修改人员：Robi
 * 修改时间：2017/06/28 09:22
 * 修改备注：
 * Version: 1.0.0
 */
public class JPush {

    static Application application;

    /**
     * 初始化
     */
    public static void init(Application application, boolean debug) {
        JPush.application = application;
        JPushInterface.setDebugMode(debug);
        JPushInterface.init(application);
    }

    /**
     * 设置别名
     */
    public static void setAlias(String alias, final TagAliasCallback aliasCallback) {
        JPushInterface.setAliasAndTags(application,
                alias,
                null,
                new TagAliasCallback() {
                    @Override
                    public void gotResult(int code, String s, Set<String> set) {
                        switch (code) {
                            case 0:
                                //"Set tag and alias success";
                                //别名设置成功
                                // 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
                                Log.i("JPush", "Set tag and alias success");
                                break;
                            case 6002:
                                // "Failed to set alias and tags due to timeout. Try again after 60s.";
                                // 延迟 60 秒来调用 Handler 设置别名
                                Log.i("JPush", "Failed to set alias and tags due to timeout. Try again after 60s.");
                                break;
                            default:
                                //"Failed with errorCode = " + code;
                                Log.i("JPush", "Failed with errorCode = " + code);
                        }

                        if (aliasCallback != null) {
                            aliasCallback.gotResult(code, s, set);
                        }
                    }
                });
    }


    /**
     * 设置通知栏样式
     */
    public static void setJPushNotification(int logo) {
        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(application);
        builder.statusBarDrawable = logo;
        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL
                | Notification.FLAG_SHOW_LIGHTS;  //设置为自动消失和呼吸灯闪烁
        builder.notificationDefaults = Notification.DEFAULT_SOUND
                | Notification.DEFAULT_VIBRATE
                | Notification.DEFAULT_LIGHTS;  // 设置为铃声、震动、呼吸灯闪烁都要
        JPushInterface.setPushNotificationBuilder(1, builder);

//        MultiActionsNotificationBuilder builder = new MultiActionsNotificationBuilder(PushSetActivity.this);
//        //添加按钮，参数(按钮图片、按钮文字、扩展数据)
//        builder.addJPushAction(R.drawable.jpush_ic_richpush_actionbar_back, "first", "my_extra1");
//        builder.addJPushAction(R.drawable.jpush_ic_richpush_actionbar_back, "second", "my_extra2");
//        builder.addJPushAction(R.drawable.jpush_ic_richpush_actionbar_back, "third", "my_extra3");
//        JPushInterface.setPushNotificationBuilder(2, builder);

//        CustomPushNotificationBuilder builder = new
//                CustomPushNotificationBuilder(application,
//                R.layout.customer_notitfication_layout,
//                R.id.icon,
//                R.id.title,
//                R.id.text);
//        // 指定定制的 Notification Layout
//        builder.statusBarDrawable = logo;
//        // 指定最顶层状态栏小图标
//        builder.layoutIconDrawable = logo;
//        // 指定下拉状态栏时显示的通知图标
//        JPushInterface.setPushNotificationBuilder(2, builder);
    }
}
