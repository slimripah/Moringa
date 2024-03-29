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
import com.slimripah.moringa.Webviews.SlackWebview;

public class Communication extends AppCompatActivity {

    LottieAnimationView lottieBubble;
    private String userEmail; // Declare userEmail as a class-level field
    private SharedPreferences sharedPreferences; // Declare sharedPreferences as a class-level field

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        lottieBubble = findViewById(R.id.bubble);

        // Retrieve the user email from the intent
        userEmail = getIntent().getStringExtra("userEmail");

        // Initialize sharedPreferences with UserPrefs
        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

    }

    public void gmail(View view) {
        if (userEmail != null) {
            String gmailUrl = "https://www.google.com/gmail/";
            Intent intent = new Intent(this, GmailWebview.class);
            intent.putExtra("urlFour", gmailUrl);
            startActivity(intent);
        }
    }

    public void slack(View view) {
        if (userEmail != null) {
            String slackUrl = "https://slack.com/";
            Intent intent = new Intent(this, SlackWebview.class);
            intent.putExtra("urlSlack", slackUrl);
            startActivity(intent);
        }

    }

}