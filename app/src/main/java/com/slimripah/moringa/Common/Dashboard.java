package com.slimripah.moringa.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.slimripah.moringa.R;

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
        openWebPage("https://docs.google.com/spreadsheets/u/0/");
    }

    public void meets(View view) {
        openWebPage("https://meet.google.com/?hs=197&authuser=0&pli=1");
    }

    public void calendar(View view) {
        openWebPage("https://calendar.google.com/calendar/u/0/r?pli=1");
    }

    public void canvas(View view) {
        openWebPage("https://moringa.instructure.com");
    }

    public void github(View view) {
        openWebPage("https://github.com/");
    }

}