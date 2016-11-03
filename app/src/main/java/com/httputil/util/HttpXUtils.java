package com.httputil.util;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/3.
 */

public class HttpXUtils {
    public static final int DEALY_TIME = 10 * 1000;// 超时时间
    private static final String TOKEN = "6B54DA131B28B449E572BE20B395C320";

    public void doGet(String url, final onDataCallBack callBack) {

        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(DEALY_TIME);
        RequestParams params = new RequestParams();
        // params.addBodyParameter("token",TOKEN);
        http.configCurrentHttpCacheExpiry(1000 * 10);//设置超时时间
        http.send(HttpMethod.GET, url, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                callBack.onSuccess(responseInfo.result);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                callBack.onFailure(e, s);
            }
        });
    }

    public void doPost(String url, HashMap<String, String> mapparams, final onDataCallBack callBack){
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(DEALY_TIME);
        RequestParams params = new RequestParams();
        if (mapparams.size() > 0) {
            for (Map.Entry<String, String> entry : mapparams.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                params.addBodyParameter(key, value);
            }
        }
        http.send(HttpMethod.POST, url, params, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                callBack.onSuccess(responseInfo.result);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                callBack.onFailure(e, s);
            }
        });

    }
}
