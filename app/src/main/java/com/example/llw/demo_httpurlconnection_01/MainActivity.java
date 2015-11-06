package com.example.llw.demo_httpurlconnection_01;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webview_id);
        handler = new Handler();
        new httpurlconntection_thread("http://www.baidu.com",webView,handler).start();
    }

}
