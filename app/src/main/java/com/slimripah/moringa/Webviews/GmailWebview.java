package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class GmailWebview extends AppCompatActivity {

    private WebView webViewFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gmail_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlFour = intent.getStringExtra("urlFour");
            webViewFour = findViewById(R.id.webViewFour);
            webViewFour.loadUrl(urlFour);
            webViewFour.setWebViewClient(new WebViewClient());
            webViewFour.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewFour.canGoBack()){
            webViewFour.goBack();
        } else {
            super.onBackPressed();
        }
    }

}