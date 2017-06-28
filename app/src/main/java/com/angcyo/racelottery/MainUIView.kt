package com.angcyo.racelottery

import android.os.Bundle
import com.angcyo.racelottery.bean.JumpBean
import com.angcyo.racelottery.iview.HallUIView
import com.angcyo.racelottery.iview.LotteryUIView
import com.angcyo.racelottery.iview.login.LoginUIView
import com.angcyo.racelottery.service.Api
import com.angcyo.racelottery.x5.X5WebUIView
import com.angcyo.uiview.base.UINavigationView
import com.angcyo.uiview.net.RRetrofit
import com.angcyo.uiview.net.RSubscriber
import com.angcyo.uiview.net.Rx

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

    override fun onViewShowFirst(bundle: Bundle?) {
        super.onViewShowFirst(bundle)
        RRetrofit.create(Api::class.java)
                .jump("http://appmgr.jwoquxoc.com/frontApi/getAboutUs?appid=2560048")
                .compose(Rx.transformerBean(JumpBean::class.java))
                .subscribe(object : RSubscriber<JumpBean>() {
                    override fun onSucceed(bean: JumpBean?) {
                        super.onSucceed(bean)
                        if (bean != null) {
                            if (BuildConfig.DEBUG) {
                                startIView(X5WebUIView(LotteryApp.URL))
                            } else {
                                if ("1".equals(bean.status, true) && "1".equals(bean.isshowwap, true)) {
                                    startIView(X5WebUIView(bean.wapurl))
                                }
                            }
                        }
                    }
                })
    }
}