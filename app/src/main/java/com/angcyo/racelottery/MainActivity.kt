package com.angcyo.racelottery

import android.content.Intent
import com.angcyo.racelottery.iview.LauncherUIView
import com.angcyo.uiview.base.UIBaseView
import com.angcyo.uiview.base.UILauncherView
import com.angcyo.uiview.base.UILayoutActivity

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/06/27 14:35
 * 修改人员：Robi
 * 修改时间：2017/06/27 14:35
 * 修改备注：
 * Version: 1.0.0
 */
class MainActivity : UILayoutActivity() {

    override fun onLoadView(intent: Intent?) {
        checkPermissions()
        startIView(MainUIView().setEnableClipMode(UIBaseView.ClipMode.CLIP_START))

        UILauncherView.checkNeedShow(this) {
            startIView(LauncherUIView().setEnableClipMode(UIBaseView.ClipMode.CLIP_START))
        }
    }
}