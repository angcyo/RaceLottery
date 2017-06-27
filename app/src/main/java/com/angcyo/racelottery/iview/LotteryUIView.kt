package com.angcyo.racelottery.iview

import android.widget.RelativeLayout
import com.angcyo.racelottery.LotteryApp
import com.angcyo.racelottery.R
import com.angcyo.racelottery.bean.LotteryBean
import com.angcyo.racelottery.x5.X5WebUIView
import com.angcyo.uiview.base.UIRecyclerUIView
import com.angcyo.uiview.recycler.RBaseItemDecoration
import com.angcyo.uiview.recycler.RBaseViewHolder
import com.angcyo.uiview.recycler.adapter.RExBaseAdapter
import com.angcyo.uiview.rsen.PlaceholderView
import com.angcyo.uiview.rsen.RefreshLayout
import com.angcyo.uiview.widget.CircleTextView

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
class LotteryUIView : UIRecyclerUIView<String, LotteryBean, String>() {

    override fun getTitleString(): String {
        return "开奖信息"
    }

    override fun getDefaultLayoutState(): LayoutState {
        return LayoutState.CONTENT
    }

    override fun onViewLoad() {
        super.onViewLoad()
        mExBaseAdapter.resetAllData(MutableList(10) {
            when (it) {
                0 -> LotteryBean("3D", "第2017062611期  2017-6-27", arrayListOf("01", "22", "09", "04"))
                1 -> LotteryBean("快3", "第2017062608期  2017-6-27", arrayListOf("10", "12", "03", "04", "11"))
                2 -> LotteryBean("单场竞赛", "第20170606期  2017-6-27", arrayListOf("01", "08", "03", "08"))
                3 -> LotteryBean("8选3", "第2017062609期  2017-6-27", arrayListOf("01", "03", "23", "04"))
                4 -> LotteryBean("快乐10分", "第20170626期  2017-6-27", arrayListOf("04", "18", "03", "03", "03", "07"))
                5 -> LotteryBean("竞彩冠军", "第20170626期  2017-6-27", arrayListOf("09", "06", "03", "34"))
                6 -> LotteryBean("时时彩", "第20170626期  2017-6-27", arrayListOf("10", "02", "23", "04", "04"))
                7 -> LotteryBean("快乐扑克", "第2017062602期  2017-6-27", arrayListOf("14", "02", "03", "04"))
                8 -> LotteryBean("快乐8", "第2017062603期  2017-6-27", arrayListOf("18", "02", "13", "04"))
                9 -> LotteryBean("双色球", "第2017062605期  2017-6-27", arrayListOf("20", "04", "09", "04"))
                else -> {
                    LotteryBean("3D", "第2017062611期", arrayListOf("01", "02", "03", "04"))
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

        mRecyclerView.addItemDecoration(RBaseItemDecoration(getDimensionPixelOffset(R.dimen.base_line), getColor(R.color.base_chat_bg_color)))
    }

    override fun createAdapter(): RExBaseAdapter<String, LotteryBean, String>? {
        return object : RExBaseAdapter<String, LotteryBean, String>(mActivity) {
            override fun getItemLayoutId(viewType: Int): Int {
                return R.layout.lottery_item_layout
            }

            override fun onBindDataView(holder: RBaseViewHolder, posInData: Int, dataBean: LotteryBean) {
                super.onBindDataView(holder, posInData, dataBean)
                holder.tv(R.id.text_view1).text = dataBean.title1
                holder.tv(R.id.text_view2).text = dataBean.title2
                //holder.imgV(R.id.image_view).setImageResource(dataBean.res)
                val circleView: CircleTextView = holder.v(R.id.circle_text_view)
                circleView.circleTextList = dataBean.numList
                holder.itemView.setOnClickListener { mParentILayout.startIView(X5WebUIView(LotteryApp.URL)) }
            }
        }
    }
}