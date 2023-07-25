package com.slimripah.moringa.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.slimripah.moringa.R;

public class Notepad extends AppCompatActivity {

    LottieAnimationView lottieTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        lottieTask = findViewById(R.id.task);

    }

    // Method to open a webpage
    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void remind(View view) {
        openWebPage("https://keep.google.com/u/0/#reminders"); // Open Reminders webpage
    }

    public void todo(View view) {
        openWebPage("https://keep.google.com/u/0/#home"); // Open Keep webpage
    }

    public void noter(View view) {
        openWebPage("https://docs.google.com/"); // Open Documents webpage
    }

}