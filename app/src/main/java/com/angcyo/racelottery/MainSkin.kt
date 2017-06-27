package com.angcyo.racelottery

import android.content.Context
import com.angcyo.uiview.skin.BaseSkin

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/06/27 14:59
 * 修改人员：Robi
 * 修改时间：2017/06/27 14:59
 * 修改备注：
 * Version: 1.0.0
 */
class MainSkin(context: Context) : BaseSkin(context) {
    override fun getThemeColor(): Int {
        return getColor(R.color.colorAccent)
    }

    override fun getThemeSubColor(): Int {
        return themeColor
    }

    override fun getThemeDarkColor(): Int {
        return getColor(R.color.colorPrimaryDark)
    }
}