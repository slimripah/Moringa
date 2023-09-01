package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class GithubWebview extends AppCompatActivity {

    private WebView webViewGit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_github_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlGit = intent.getStringExtra("urlGit");
            webViewGit = findViewById(R.id.webViewGit);
            webViewGit.loadUrl(urlGit);
            webViewGit.setWebViewClient(new WebViewClient());
            webViewGit.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewGit.canGoBack()){
            webViewGit.goBack();
        } else {
            super.onBackPressed();
        }
    }

}