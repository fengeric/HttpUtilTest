package com.volleyHttp.util;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * 使用Volley访问Http请求管理的工具类
 *
 * @author Eric
 * @date 2016/10/31
 **/
public class HttpVolleyUtils {
    private static RequestQueue mRequestQueue;

    /**
     * Get请求，获得返回数据
     *
     * @param context 上下文
     * @param url     发送请求的URL
     * @param vif     请求回调的接口（请求成功或者失败）
     */
    public static void doGet(Context context, String url, VolleyInterface vif) {
        Log.e("lala", "发送GET请求的URL" + url);
        mRequestQueue = Volley.newRequestQueue(context);
        //实例化StringRequest
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, vif.loadingListener(), vif.errorListener());
        // 将请求添加至队列里面
        mRequestQueue.add(stringRequest);
        // 启动
        mRequestQueue.start();
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param context 上下文
     * @param url     发送请求的URL
     * @param params  请求参数，请求参数应该是Hashmap类型
     * @param vif     请求回调的接口（请求成功或者失败）
     */
    public static void doPost(Context context, String url, final Map<String, String> params,
                              VolleyInterface vif) {
        mRequestQueue = Volley.newRequestQueue(context);
        Log.e("lala", "发送Post请求的URL" + url);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, vif.loadingListener(), vif.errorListener()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        // 加入队列
        mRequestQueue.add(stringRequest);
        // 启动
        mRequestQueue.start();
    }
}
