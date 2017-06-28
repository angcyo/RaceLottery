package com.angcyo.racelottery.service;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2017/06/28 14:56
 * 修改人员：Robi
 * 修改时间：2017/06/28 14:56
 * 修改备注：
 * Version: 1.0.0
 */
public interface Api {

    @GET()
    Observable<ResponseBody> jump(@Url String url);

}
