package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class RemindersWebview extends AppCompatActivity {

    private WebView webViewFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_reminders_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlFive = intent.getStringExtra("urlFive");
            webViewFive = findViewById(R.id.webViewFive);
            webViewFive.loadUrl(urlFive);
            webViewFive.setWebViewClient(new WebViewClient());
            webViewFive.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewFive.canGoBack()){
            webViewFive.goBack();
        } else {
            super.onBackPressed();
        }
    }

}