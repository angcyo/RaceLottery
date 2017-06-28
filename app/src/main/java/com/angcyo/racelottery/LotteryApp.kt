package com.angcyo.racelottery

import android.content.Intent
import com.angcyo.jpush.JPush
import com.angcyo.jpush.JPushReceiver
import com.angcyo.uiview.RApplication
import com.angcyo.uiview.Root
import com.angcyo.uiview.skin.SkinHelper

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/06/27 14:01
 * 修改人员：Robi
 * 修改时间：2017/06/27 14:01
 * 修改备注：
 * Version: 1.0.0
 */
class LotteryApp : RApplication() {

    companion object {
        const val URL = "http://ing-c.ww-app.com/1.html"
    }

    override fun onInit() {
        super.onInit()
        SkinHelper.init(MainSkin(applicationContext))

        Root.APP_FOLDER = "RaceLottery"

        JPush.init(this, BuildConfig.DEBUG)
        JPush.setAlias(getIMEI(), null)

        JPushReceiver.JPushReceiveCallback = JPushReceiver.JPushReceiveCallback { context, intent ->
            if ("cn.jpush.android.intent.NOTIFICATION_OPENED".equals(intent.action, ignoreCase = true)) {
                val intent1 = Intent(context, MainActivity::class.java)
                intent1.putExtra("jump", true)
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent1)
            }
        }
    }
}