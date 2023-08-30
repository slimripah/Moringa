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
import com.slimripah.moringa.Webviews.NotesWebview;
import com.slimripah.moringa.Webviews.RemindersWebview;
import com.slimripah.moringa.Webviews.SheetsWebview;
import com.slimripah.moringa.Webviews.TasksWebview;

public class Notepad extends AppCompatActivity {

    LottieAnimationView lottieTask;
    private String userEmail; // Declare userEmail as a class-level field
    private SharedPreferences sharedPreferences; // Declare sharedPreferences as a class-level field

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        lottieTask = findViewById(R.id.task);

        // Retrieve the user email from the intent
        userEmail = getIntent().getStringExtra("userEmail");

        // Initialize sharedPreferences with UserPrefs
        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

    }

    public void remind(View view) {
        if (userEmail != null) {
            String RemindersUrl = "https://keep.google.com/u/0/#reminders";
            Intent intent = new Intent(this, RemindersWebview.class);
            intent.putExtra("urlFive", RemindersUrl);
            startActivity(intent);
        }

    }

    public void todo(View view) {
        if (userEmail != null) {
            String TasksUrl = "https://keep.google.com/u/0/#home";
            Intent intent = new Intent(this, TasksWebview.class);
            intent.putExtra("urlSix", TasksUrl);
            startActivity(intent);
        }
    }

    public void noter(View view) {
        if (userEmail != null) {
            String notesUrl = "https://docs.google.com/";
            Intent intent = new Intent(this, NotesWebview.class);
            intent.putExtra("urlSeven", notesUrl);
            startActivity(intent);
        }
    }

}