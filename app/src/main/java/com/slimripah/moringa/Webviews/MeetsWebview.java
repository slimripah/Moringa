package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class MeetsWebview extends AppCompatActivity {

    private WebView webViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_meets_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlTwo = intent.getStringExtra("urlTwo");
            webViewTwo = findViewById(R.id.webViewTwo);
            webViewTwo.loadUrl(urlTwo);
            webViewTwo.setWebViewClient(new WebViewClient());
            webViewTwo.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewTwo.canGoBack()){
            webViewTwo.goBack();
        } else {
            super.onBackPressed();
        }
    }

}