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
import com.slimripah.moringa.Webviews.BlogWebview;
import com.slimripah.moringa.Webviews.CalendarWebview;
import com.slimripah.moringa.Webviews.CanvasWebview;
import com.slimripah.moringa.Webviews.GithubWebview;
import com.slimripah.moringa.Webviews.MeetsWebview;
import com.slimripah.moringa.Webviews.PortalWebview;
import com.slimripah.moringa.Webviews.SheetsWebview;
import com.slimripah.moringa.Webviews.SiteWebview;

public class Dashboard extends AppCompatActivity {

    private TextView name; // TextView to display the user's name
    private String userEmail; // Declare userEmail as a class-level field
    private SharedPreferences sharedPreferences; // Declare sharedPreferences as a class-level field

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        name = findViewById(R.id.name);

        // Retrieve the user's name from the intent
        String personName = getIntent().getStringExtra("personName");
        name.setText(personName); // Display the user's name in the TextView

        // Retrieve stored user account information
        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        userEmail = sharedPreferences.getString("userEmail", null);

    }

    // Button click listeners
    public void scan(View view) {
        startActivity(new Intent(this, CodeScanner.class));
    }

    public void health(View view) {
        startActivity(new Intent(this, Wellness.class));
    }

    public void contact(View view) {
        if (userEmail != null) {
            Intent intent = new Intent(this, Communication.class);
            intent.putExtra("userEmail", userEmail);
            startActivity(intent);
        }
    }

    public void note(View view) {
        if (userEmail != null) {
            Intent intent = new Intent(this, Notepad.class);
            intent.putExtra("userEmail", userEmail);
            startActivity(intent);
        }
    }

    public void blog(View view) {
        Intent intent = new Intent(Dashboard.this, BlogWebview.class);
        intent.putExtra("urlBlog", "https://moringa-alumni.vercel.app/");
        startActivity(intent);
    }

    public void profile(View view) {
        Intent intent = new Intent(Dashboard.this, PortalWebview.class);
        intent.putExtra("urlZero", "https://moringa-student-portal.vercel.app/");
        startActivity(intent);
    }

    public void web(View view) {

        String url = "https://moringaschool.com/";
        Intent intent = new Intent(this, SiteWebview.class);
        intent.putExtra("urlSite", url);
        startActivity(intent);
    }

    public void sheets(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

        if (userEmail != null) {
            String sheetsUrl = "https://docs.google.com/spreadsheets/";
            Intent intent = new Intent(this, SheetsWebview.class);
            intent.putExtra("urlOne", sheetsUrl);
            startActivity(intent);
        }

    }

    public void meets(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

        if (userEmail != null) {
            String meetsUrl = "https://meet.google.com/";
            Intent intent = new Intent(this, MeetsWebview.class);
            intent.putExtra("urlTwo", meetsUrl);
            startActivity(intent);
        }

    }

    public void calendar(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("userEmail", null);

        if (userEmail != null) {
            String calendarUrl = "https://calendar.google.com/";
            Intent intent = new Intent(this, CalendarWebview.class);
            intent.putExtra("urlThree", calendarUrl);
            startActivity(intent);
        }

    }

    public void canvas(View view) {
        Intent intent = new Intent(Dashboard.this, CanvasWebview.class);
        intent.putExtra("urlCanvas", "https://moringa.instructure.com");
        startActivity(intent);
    }

    public void github(View view) {
        Intent intent = new Intent(Dashboard.this, GithubWebview.class);
        intent.putExtra("urlGit", "https://github.com/");
        startActivity(intent);
    }

}