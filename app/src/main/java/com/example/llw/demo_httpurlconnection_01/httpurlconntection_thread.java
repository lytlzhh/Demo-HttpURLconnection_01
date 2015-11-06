package com.example.llw.demo_httpurlconnection_01;

import android.os.Handler;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by llw on 2015/11/6.
 */
public class httpurlconntection_thread extends Thread {
    private String url;
    private WebView webView;
    private Handler handler;

    httpurlconntection_thread(String url, WebView webView, Handler handler) {
        this.url = url;
        this.webView = webView;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            URL myurl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) myurl.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(1000 * 5);
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            final StringBuffer stringBuffer = new StringBuffer();
            String srt=null;
            while ((srt=bufferedReader.readLine())!=null){
                stringBuffer.append(srt);
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                 webView.loadData(stringBuffer.toString(),"text/html;charset=utf-8",null);
        }
    });

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
