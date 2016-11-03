package com.volleyHttp.util;/**
 * Created by Administrator on 2016/10/31.
 */

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * @author: xiaolijuan
 * @description: 请求成功或失败的接口回调
 * @date: 2016-03-15
 * @time: 15:39
 */
public abstract class VolleyInterface {
    /**
     * 上下文
     */
    public Context mContext;
    /**
     * 请求成功监听
     */
    public static Response.Listener<String> mListener;
    /**
     * 请求失败监听
     */
    public static Response.ErrorListener mErrorListtener;

    public VolleyInterface(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this.mContext = context;
        this.mListener = listener;
        this.mErrorListtener = errorListener;
    }

    /**
     * 请求成功的抽象类
     *
     * @param result
     */
    public abstract void onSuccess(String result);

    /**
     * 请求失败的抽象类
     *
     * @param error
     */
    public abstract void onError(VolleyError error);

    /**
     * 请求成功监听
     *
     * @return
     */
    public Response.Listener<String> loadingListener() {
        mListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String result) {
                Log.v("请求成功返回的数据：", result);
                onSuccess(result);
            }
        };
        return mListener;
    }

    /**
     * 请求失败监听
     *
     * @return
     */
    public Response.ErrorListener errorListener() {
        mErrorListtener = new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("请求失败返回的数据：", error.toString());
                onError(error);
            }
        };
        return mErrorListtener;
    }
}
