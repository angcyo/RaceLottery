package com.angcyo.racelottery

import com.angcyo.racelottery.iview.HallUIView
import com.angcyo.racelottery.iview.LotteryUIView
import com.angcyo.racelottery.iview.login.LoginUIView
import com.angcyo.uiview.base.UINavigationView

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/06/27 14:26
 * 修改人员：Robi
 * 修改时间：2017/06/27 14:26
 * 修改备注：
 * Version: 1.0.0
 */
class MainUIView : UINavigationView() {
    override fun createPages(pages: ArrayList<PageBean>) {
        pages.add(PageBean(HallUIView(), "", null, null, null, R.drawable.tab_hall_normal, R.drawable.tab_hall_pressed))
        pages.add(PageBean(LotteryUIView(), "", null, null, null, R.drawable.tab_award_normal, R.drawable.tab_award_pressed))
        pages.add(PageBean(LoginUIView(), "", null, null, null, R.drawable.tab_mine_normal, R.drawable.tab_mine_pressed))
    }
}