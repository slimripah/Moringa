package com.slimripah.moringa.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.slimripah.moringa.R;
import com.slimripah.moringa.Webviews.GmailWebview;
import com.slimripah.moringa.Webviews.SheetsWebview;

public class Communication extends AppCompatActivity {

    LottieAnimationView lottieBubble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        lottieBubble = findViewById(R.id.bubble);

        // Retrieve stored user account information
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

    }

    // Method to open a webpage
    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void gmail(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

        if (userEmail != null) {
            String gmailUrl = "https://www.google.com/gmail/";
            Intent intent = new Intent(this, GmailWebview.class);
            intent.putExtra("urlFour", gmailUrl);
            startActivity(intent);
        }
    }

    public void slack(View view) {
        openWebPage("https://slack.com/"); // Open Slack webpage
    }

}