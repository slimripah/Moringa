package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class CalendarWebview extends AppCompatActivity {

    private WebView webViewThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_calendar_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlThree = intent.getStringExtra("urlThree");
            webViewThree = findViewById(R.id.webViewThree);
            webViewThree.loadUrl(urlThree);
            webViewThree.setWebViewClient(new WebViewClient());
            webViewThree.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewThree.canGoBack()){
            webViewThree.goBack();
        } else {
            super.onBackPressed();
        }
    }

}