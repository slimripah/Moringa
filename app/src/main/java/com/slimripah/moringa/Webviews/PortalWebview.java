package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class PortalWebview extends AppCompatActivity {

    private WebView webViewZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_portal_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlZero = intent.getStringExtra("urlZero");
            webViewZero = findViewById(R.id.webViewZero);
            webViewZero.loadUrl(urlZero);
            webViewZero.setWebViewClient(new WebViewClient());
            webViewZero.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewZero.canGoBack()){
            webViewZero.goBack();
        } else {
            super.onBackPressed();
        }
    }

}