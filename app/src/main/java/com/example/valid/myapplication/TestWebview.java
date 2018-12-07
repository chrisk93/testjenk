package com.example.valid.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.BindView;

public class TestWebview extends AppCompatActivity {

    @BindView(R.id.webview1)
    WebView webview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_webview);
    }

    public void naa(){
        WebSettings webSettings = webview1.getSettings();
        webSettings.setAllowFileAccess(false);
    }
}
