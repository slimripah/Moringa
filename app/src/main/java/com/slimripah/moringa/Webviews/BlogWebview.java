package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class BlogWebview extends AppCompatActivity {

    private WebView webViewBlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_blog_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlBlog = intent.getStringExtra("urlBlog");
            webViewBlog = findViewById(R.id.webViewBlog);
            webViewBlog.loadUrl(urlBlog);
            webViewBlog.setWebViewClient(new WebViewClient());
            webViewBlog.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewBlog.canGoBack()){
            webViewBlog.goBack();
        } else {
            super.onBackPressed();
        }
    }

}