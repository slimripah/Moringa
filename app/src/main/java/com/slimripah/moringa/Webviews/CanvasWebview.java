package com.slimripah.moringa.Webviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.slimripah.moringa.R;

public class CanvasWebview extends AppCompatActivity {

    private WebView webViewCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_canvas_webview);

        // Retrieve the URL from the intent's extra
        Intent intent = getIntent();
        if (intent != null) {
            String urlCanvas = intent.getStringExtra("urlCanvas");
            webViewCanvas = findViewById(R.id.webViewCanvas);
            webViewCanvas.loadUrl(urlCanvas);
            webViewCanvas.setWebViewClient(new WebViewClient());
            webViewCanvas.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        }

    }

    //go back one step else go back to main activity
    @Override
    public void onBackPressed() {
        if (webViewCanvas.canGoBack()){
            webViewCanvas.goBack();
        } else {
            super.onBackPressed();
        }
    }

}