package com.volleyHttp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.httputil.Main2;
import com.volleyHttp.util.HttpVolleyUtils;
import com.volleyHttp.util.VolleyInterface;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    TextView tv2;
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

    public void btnHttpUtil(View view) {
        startActivity(new Intent(MainActivity.this, Main2.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.sss);
        tv2 = (TextView) findViewById(R.id.sss2);

        HttpVolleyUtils.doGet(getApplicationContext(), appendUrl(url_get), new VolleyInterface(getApplicationContext(), VolleyInterface.mListener, VolleyInterface.mErrorListtener) {
            @Override
            public void onSuccess(String result) {
                tv.setText(result);

            }

            @Override
            public void onError(VolleyError error) {
                tv.setText(error.getMessage());
            }
        });

        Map<String, String> map = new HashMap<String, String>();
        map.put("UserName", "18501630652");
        map.put("Password", "123456");
        map.put("token", TOKEN);

        HttpVolleyUtils.doPost(getApplicationContext(), appendUrl(url_post), map, new VolleyInterface(getApplicationContext(), VolleyInterface.mListener, VolleyInterface.mErrorListtener) {
            @Override
            public void onSuccess(String result) {
                tv2.setText(result);
            }

            @Override
            public void onError(VolleyError error) {
                tv2.setText(error.toString());
            }
        });
    }
}
