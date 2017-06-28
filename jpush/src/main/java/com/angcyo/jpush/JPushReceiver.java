package com.angcyo.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：极光推送过来的广播
 * 创建人员：Robi
 * 创建时间：2017/06/28 09:08
 * 修改人员：Robi
 * 修改时间：2017/06/28 09:08
 * 修改备注：
 * Version: 1.0.0
 */
public class JPushReceiver extends BroadcastReceiver {

    public static JPushReceiveCallback JPushReceiveCallback;

    @Override
    public void onReceive(Context context, Intent intent) {
        /*
        * <action android:name="cn.jpush.android.intent.REGISTRATION"/> <!--Required  用户注册SDK的intent-->
                <action android:name="cn.jpush.android.intent.MESSAGE_RECEIVED"/> <!--Required  用户接收SDK消息的intent-->
                <action android:name="cn.jpush.android.intent.NOTIFICATION_RECEIVED"/> <!--Required  用户接收SDK通知栏信息的intent-->
                <action android:name="cn.jpush.android.intent.NOTIFICATION_OPENED"/> <!--Required  用户打开自定义通知栏的intent-->
                <action android:name="cn.jpush.android.intent.CONNECTION"/><!-- 接收网络变化 连接/断开 since 1.6.3 -->
        * */

        String action = intent.getAction();
        Log.i("JPush", "收到广播:" + action);

        if ("cn.jpush.android.intent.REGISTRATION".equalsIgnoreCase(action)) {
            Bundle bundle = intent.getExtras();
            String id = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
            Log.i("JPush", "注册id:" + id);
        } else if ("cn.jpush.android.intent.MESSAGE_RECEIVED".equalsIgnoreCase(action)) {
            //自定义的消息
//            Bundle bundle = intent.getExtras();
//            String title = bundle.getString(JPushInterface.EXTRA_TITLE);//标题
//            String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);//消息
//            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);//扩展字段
//            String type = bundle.getString(JPushInterface.EXTRA_CONTENT_TYPE);
//            String file = bundle.getString(JPushInterface.EXTRA_RICHPUSH_FILE_PATH);
//            String id = bundle.getString(JPushInterface.EXTRA_MSG_ID);
//            String file3 = bundle.getString(JPushInterface.EXTRA_MSG_ID);

        } else if ("cn.jpush.android.intent.NOTIFICATION_RECEIVED".equalsIgnoreCase(action)) {

        } else if ("cn.jpush.android.intent.NOTIFICATION_OPENED".equalsIgnoreCase(action)) {

        } else if ("cn.jpush.android.intent.CONNECTION".equalsIgnoreCase(action)) {

        }

        if (JPushReceiveCallback != null) {
            JPushReceiveCallback.onReceive(context, intent);
        }
    }

    public interface JPushReceiveCallback {
        void onReceive(Context context, Intent intent);
    }
}
