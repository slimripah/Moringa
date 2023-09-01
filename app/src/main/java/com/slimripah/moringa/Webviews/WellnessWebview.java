package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class WellnessWebview extends AppCompatActivity {

    private WebView webViewWell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wellness_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlWell = intent.getStringExtra("urlWell");
            webViewWell = findViewById(R.id.webViewWell);
            webViewWell.loadUrl(urlWell);
            webViewWell.setWebViewClient(new WebViewClient());
            webViewWell.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewWell.canGoBack()){
            webViewWell.goBack();
        } else {
            super.onBackPressed();
        }
    }

}