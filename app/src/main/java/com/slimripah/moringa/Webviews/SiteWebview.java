package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class SiteWebview extends AppCompatActivity {

    private WebView webViewSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_site_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlSite = intent.getStringExtra("urlSite");
            webViewSite = findViewById(R.id.webViewSite);
            webViewSite.loadUrl(urlSite);
            webViewSite.setWebViewClient(new WebViewClient());
            webViewSite.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewSite.canGoBack()){
            webViewSite.goBack();
        } else {
            super.onBackPressed();
        }
    }

}