package com.angcyo.racelottery.iview.login;

import android.Manifest;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;

import com.angcyo.racelottery.R;
import com.angcyo.racelottery.iview.base.BaseItemUIView;
import com.angcyo.uiview.base.Item;
import com.angcyo.uiview.base.SingleItem;
import com.angcyo.uiview.dialog.UILoading;
import com.angcyo.uiview.model.TitleBarPattern;
import com.angcyo.uiview.recycler.RBaseViewHolder;
import com.angcyo.uiview.utils.T_;
import com.angcyo.uiview.widget.ExEditText;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.List;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/05/09 16:47
 * 修改人员：Robi
 * 修改时间：2017/05/09 16:47
 * 修改备注：
 * Version: 1.0.0
 */
public class RegisterUIView extends BaseItemUIView {
    @Override
    protected TitleBarPattern getTitleBar() {
        return super.getTitleBar().setTitleString("注册").setShowBackImageView(true);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.view_register;
    }

    @Override
    protected void initOnShowContentLayout() {
        super.initOnShowContentLayout();
        new RxPermissions(mActivity)
                .request(Manifest.permission.READ_PHONE_STATE)
                .subscribe();
    }

    @Override
    protected void createItems(List<SingleItem> items) {
        items.add(new SingleItem() {
            @Override
            public void onBindView(RBaseViewHolder holder, int posInData, Item dataBean) {
                TextInputLayout userNameLayout = holder.v(R.id.user_name_layout);
                TextInputLayout userPasswordLayout = holder.v(R.id.user_password_layout);
                TextInputLayout reUserPasswordLayout = holder.v(R.id.re_user_password_layout);

                userNameLayout.setHint("请输入手机号码");
                userPasswordLayout.setHint("请输入密码(最少6位)");
                reUserPasswordLayout.setHint("请确认密码(最少6位)");

                final ExEditText userName = (ExEditText) userNameLayout.findViewById(R.id.edit_text);
                final ExEditText userPassword = (ExEditText) userPasswordLayout.findViewById(R.id.edit_text);
                final ExEditText reUserPassword = (ExEditText) reUserPasswordLayout.findViewById(R.id.edit_text);

                userName.setIsPhone(true, 11);
                userPassword.setIsPassword(true);
                reUserPassword.setIsPassword(true);

                //登录
                holder.v(R.id.register_view).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!userName.checkEmpty(true) && !userPassword.checkMinLength(6) && !reUserPassword.checkMinLength(6)) {
                            if (TextUtils.equals(userPassword.string(), reUserPassword.string())) {
                                register(userName.string(), userPassword.string());
                            } else {
                                T_.error("2次输入的密码不一致.");
                            }
                        }
                    }
                });
            }
        });
    }

    private void register(final String uid, final String pwd) {
        UILoading.show2(mParentILayout);
    }
}
