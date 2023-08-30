package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class TasksWebview extends AppCompatActivity {

    private WebView webViewSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tasks_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlSix = intent.getStringExtra("urlSix");
            webViewSix = findViewById(R.id.webViewSix);
            webViewSix.loadUrl(urlSix);
            webViewSix.setWebViewClient(new WebViewClient());
            webViewSix.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewSix.canGoBack()){
            webViewSix.goBack();
        } else {
            super.onBackPressed();
        }
    }

}