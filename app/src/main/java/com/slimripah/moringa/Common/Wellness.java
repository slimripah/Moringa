package com.slimripah.moringa.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.slimripah.moringa.R;
import com.slimripah.moringa.Webviews.BlogWebview;
import com.slimripah.moringa.Webviews.WellnessWebview;

public class Wellness extends AppCompatActivity {

    LottieAnimationView lottieWell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellness);

        lottieWell = findViewById(R.id.health);

        // Retrieve stored user account information
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

    }

    public void fill(View view) {
        Intent intent = new Intent(Wellness.this, WellnessWebview.class);
        intent.putExtra("urlWell", "https://docs.google.com/forms/");
        startActivity(intent);
    }

}