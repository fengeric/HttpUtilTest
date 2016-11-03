package com.httputil.util;

import com.lidroid.xutils.exception.HttpException;

/**
 * Created by Administrator on 2016/11/3.
 */

public interface onDataCallBack {
    public void onSuccess(String result);
    public void onFailure(HttpException e, String errorResutl);
}
