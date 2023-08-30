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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        lottieTask = findViewById(R.id.task);

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

    public void remind(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

        if (userEmail != null) {
            String RemindersUrl = "https://keep.google.com/u/0/#reminders";
            Intent intent = new Intent(this, RemindersWebview.class);
            intent.putExtra("urlFive", RemindersUrl);
            startActivity(intent);
        }

    }

    public void todo(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

        if (userEmail != null) {
            String TasksUrl = "https://keep.google.com/u/0/#home";
            Intent intent = new Intent(this, TasksWebview.class);
            intent.putExtra("urlSix", TasksUrl);
            startActivity(intent);
        }
    }

    public void noter(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

        if (userEmail != null) {
            String notesUrl = "https://docs.google.com/";
            Intent intent = new Intent(this, NotesWebview.class);
            intent.putExtra("urlSeven", notesUrl);
            startActivity(intent);
        }
    }

}