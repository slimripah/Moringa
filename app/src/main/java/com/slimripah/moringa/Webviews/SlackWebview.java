package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class SlackWebview extends AppCompatActivity {

    private WebView webViewSlack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_slack_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlSlack = intent.getStringExtra("urlSlack");
            webViewSlack = findViewById(R.id.webViewSlack);
            webViewSlack.loadUrl(urlSlack);
            webViewSlack.setWebViewClient(new WebViewClient());
            webViewSlack.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewSlack.canGoBack()){
            webViewSlack.goBack();
        } else {
            super.onBackPressed();
        }
    }

}