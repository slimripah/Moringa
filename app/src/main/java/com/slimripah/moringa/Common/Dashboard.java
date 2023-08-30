package com.slimripah.moringa.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.slimripah.moringa.R;
import com.slimripah.moringa.Webviews.CalendarWebview;
import com.slimripah.moringa.Webviews.MeetsWebview;
import com.slimripah.moringa.Webviews.SheetsWebview;

public class Dashboard extends AppCompatActivity {

    private TextView name; // TextView to display the user's name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        name = findViewById(R.id.name);

        // Retrieve the user's name from the intent
        String personName = getIntent().getStringExtra("personName");
        name.setText(personName); // Display the user's name in the TextView

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

    // Button click listeners
    public void scan(View view) {
        startActivity(new Intent(this, CodeScanner.class));
    }

    public void health(View view) {
        startActivity(new Intent(this, Wellness.class));
    }

    public void contact(View view) {
        startActivity(new Intent(this, Communication.class));
    }

    public void note(View view) {
        startActivity(new Intent(this, Notepad.class));
    }

    public void blog(View view) {
        openWebPage("https://moringa-alumni.vercel.app/");
    }

    public void profile(View view) {
        openWebPage("https://myaccount.google.com/");
    }

    public void web(View view) {
        openWebPage("https://moringaschool.com/");
    }

    public void sheets(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

        if (userEmail != null) {
            String sheetsUrl = "https://docs.google.com/spreadsheets/u/0/";
            Intent intent = new Intent(this, SheetsWebview.class);
            intent.putExtra("urlOne", sheetsUrl);
            startActivity(intent);
        }

    }

    public void meets(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

        if (userEmail != null) {
            String meetsUrl = "https://meet.google.com/?hs=197&authuser=0&pli=1";
            Intent intent = new Intent(this, MeetsWebview.class);
            intent.putExtra("urlTwo", meetsUrl);
            startActivity(intent);
        }

    }

    public void calendar(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

        if (userEmail != null) {
            String calendarUrl = "https://calendar.google.com/calendar/u/0/r?pli=1";
            Intent intent = new Intent(this, CalendarWebview.class);
            intent.putExtra("urlThree", calendarUrl);
            startActivity(intent);
        }

    }

    public void canvas(View view) {
        openWebPage("https://moringa.instructure.com");
    }

    public void github(View view) {
        openWebPage("https://github.com/");
    }

}