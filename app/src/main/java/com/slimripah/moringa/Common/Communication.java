package com.slimripah.moringa.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.slimripah.moringa.R;

public class Communication extends AppCompatActivity {

    LottieAnimationView lottieBubble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        lottieBubble = findViewById(R.id.bubble);

    }

    // Method to open a webpage
    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void gmail(View view) {
        openWebPage("https://www.google.com/gmail/"); // Open Gmail webpage
    }

    public void slack(View view) {
        openWebPage("https://slack.com/"); // Open Slack webpage
    }

}