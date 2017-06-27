package com.angcyo.racelottery.iview

import android.support.v7.widget.GridLayoutManager
import android.widget.RelativeLayout
import com.angcyo.racelottery.LotteryApp
import com.angcyo.racelottery.R
import com.angcyo.racelottery.bean.HallBean
import com.angcyo.racelottery.x5.X5WebUIView
import com.angcyo.uiview.base.UIRecyclerUIView
import com.angcyo.uiview.recycler.RBaseViewHolder
import com.angcyo.uiview.recycler.adapter.RExBaseAdapter
import com.angcyo.uiview.rsen.PlaceholderView
import com.angcyo.uiview.rsen.RefreshLayout

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/06/27 14:32
 * 修改人员：Robi
 * 修改时间：2017/06/27 14:32
 * 修改备注：
 * Version: 1.0.0
 */
class HallUIView : UIRecyclerUIView<String, HallBean, String>() {

    override fun getTitleString(): String {
        return "256体彩"
    }

    override fun getDefaultLayoutState(): LayoutState {
        return LayoutState.CONTENT
    }

    override fun onViewLoad() {
        super.onViewLoad()
        mExBaseAdapter.resetAllData(MutableList(12) {
            when (it) {
                2 -> HallBean(R.drawable.logo_3d, "3D", "暂停销售")
                3 -> HallBean(R.drawable.logo_ahk3, "快3", "暂停销售")
                4 -> HallBean(R.drawable.logo_bjdc, "单场竞赛", "暂停销售")
                5 -> HallBean(R.drawable.logo_feiyu, "8选3", "火爆进行中")
                6 -> HallBean(R.drawable.logo_gdklsf, "快乐10分", "火爆进行中")
                7 -> HallBean(R.drawable.logo_jcgj, "竞彩冠军", "火爆进行中")
                8 -> HallBean(R.drawable.logo_jxssc, "时时彩", "暂停销售")
                9 -> HallBean(R.drawable.logo_klpk3, "快乐扑克", "火爆进行中")
                10 -> HallBean(R.drawable.logo_kl8, "快乐8", "火爆进行中")
                11 -> HallBean(R.drawable.logo_ssq, "双色球", "暂停销售")
                else -> {
                    HallBean(1, "", "")
                }
            }
        })
    }

    override fun afterInflateView(baseContentLayout: RelativeLayout?) {
        super.afterInflateView(baseContentLayout)
        mRefreshLayout.setTopView(PlaceholderView(mActivity))
        mRefreshLayout.setBottomView(PlaceholderView(mActivity))
        mRefreshLayout.setNotifyListener(false)
        mRefreshLayout.setRefreshDirection(RefreshLayout.BOTH)

        val layoutManager = GridLayoutManager(mActivity, 2)
        mRecyclerView.layoutManager = layoutManager

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0, 1 -> 2
                    else -> {
                        1
                    }
                }
            }
        }
    }

    override fun createAdapter(): RExBaseAdapter<String, HallBean, String> {
        return object : RExBaseAdapter<String, HallBean, String>(mActivity) {
            override fun getItemLayoutId(viewType: Int): Int {
                return when (viewType) {
                    0 -> R.layout.hall_item1
                    1 -> R.layout.hall_item2
                    else -> {
                        R.layout.hall_item3
                    }
                }
            }

            override fun getDataItemType(posInData: Int): Int {
                if (posInData < 2) {
                    return posInData
                }
                return 3
            }

            override fun onBindDataView(holder: RBaseViewHolder, posInData: Int, dataBean: HallBean) {
                super.onBindDataView(holder, posInData, dataBean)
                when (posInData) {
                    0 -> holder.imgV(R.id.image_view).setImageResource(R.drawable.tab_login_icon)
                    1 -> holder.imgV(R.id.image_view).setImageResource(R.drawable.cs50_logo)
                    else -> {
                        holder.tv(R.id.text_view1).text = dataBean.title1
                        holder.tv(R.id.text_view2).text = dataBean.title2
                        holder.imgV(R.id.image_view).setImageResource(dataBean.res)

                        holder.itemView.setOnClickListener { mParentILayout.startIView(X5WebUIView(LotteryApp.URL)) }
                    }
                }
            }
        }
    }
}