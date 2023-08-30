package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class NotesWebview extends AppCompatActivity {

    private WebView webViewSeven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_notes_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlSeven = intent.getStringExtra("urlOne");
            webViewSeven = findViewById(R.id.webViewSeven);
            webViewSeven.loadUrl(urlSeven);
            webViewSeven.setWebViewClient(new WebViewClient());
            webViewSeven.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewSeven.canGoBack()){
            webViewSeven.goBack();
        } else {
            super.onBackPressed();
        }
    }

}