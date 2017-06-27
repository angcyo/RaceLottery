package com.angcyo.racelottery.iview

import android.widget.ImageView
import com.angcyo.racelottery.R
import com.angcyo.uiview.base.UILauncherView
import com.angcyo.uiview.model.TitleBarPattern

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/06/27 14:18
 * 修改人员：Robi
 * 修改时间：2017/06/27 14:18
 * 修改备注：
 * Version: 1.0.0
 */
class LauncherUIView : UILauncherView() {

    override fun getTitleBar(): TitleBarPattern? {
        return null
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onCreateItem(imageView: ImageView, position: Int) {
        when (position) {
            0 -> imageView.setImageResource(R.drawable.launcher_1)
            1 -> imageView.setImageResource(R.drawable.launcher_2)
            2 -> imageView.setImageResource(R.drawable.launcher_3)
            3 -> imageView.setImageResource(R.drawable.launcher_4)
        }
    }

    override fun onPagerEnd() {
        finishIView()
    }
}