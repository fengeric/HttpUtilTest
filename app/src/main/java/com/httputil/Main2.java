package com.httputil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.httputil.util.HttpXUtils;
import com.httputil.util.onDataCallBack;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.volleyHttp.R;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/11/1.
 */

public class Main2 extends Activity {

    String url_get = "https://api.057life.com/api/home/getAdverts";
    String url_post = "https://api.057life.com/api/member/login";
    private static final String TOKEN = "6B54DA131B28B449E572BE20B395C320";

    public static String appendUrl(String url) {
        try {
            url = url + "?token=" + TOKEN;
        } catch (Exception e) {
        }
        return url;
    }

    @ViewInject(R.id.sss)
    TextView textView;
    @ViewInject(R.id.sss2)
    TextView textView2;
    @ViewInject(R.id.bt)
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        ViewUtils.inject(this);

        textView.setText("hahaha");
        bt.setText("ViewUtils依赖注入");

        HttpXUtils util = new HttpXUtils();
        util.doGet(appendUrl(url_get), new onDataCallBack() {
            @Override
            public void onSuccess(String result) {
                textView.setText(result);
            }

            @Override
            public void onFailure(HttpException e, String errorResutl) {
                textView.setText("e.toString:" + e.toString() + "\n" + "errorResult:" + errorResutl);
            }
        });

        HashMap<String, String> mapParams = new HashMap<String, String>();
        mapParams.put("Password", "18501630652");
        mapParams.put("UserName", "123456");
        mapParams.put("token", TOKEN);
        util.doPost(appendUrl(url_post), mapParams, new onDataCallBack() {
            @Override
            public void onSuccess(String result) {
                textView2.setText(result);
            }

            @Override
            public void onFailure(HttpException e, String errorResutl) {
                textView2.setText("e.toString:" + e.toString() + "\n" + "errorResult:" + errorResutl);
            }
        });
    }


    @OnClick(R.id.bt)
    public void bt(View view) {
        Toast.makeText(getApplicationContext(), "ViewUtils依赖注入", Toast.LENGTH_LONG).show();
    }
}
