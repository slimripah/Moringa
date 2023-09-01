package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class SheetsWebview extends AppCompatActivity {

    private WebView webViewOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sheets_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlOne = intent.getStringExtra("urlOne");
            webViewOne = findViewById(R.id.webViewOne);
            webViewOne.loadUrl(urlOne);
            webViewOne.setWebViewClient(new WebViewClient());
            webViewOne.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewOne.canGoBack()){
            webViewOne.goBack();
        } else {
            super.onBackPressed();
        }
    }

}