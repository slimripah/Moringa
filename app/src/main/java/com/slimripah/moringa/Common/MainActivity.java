package com.slimripah.moringa.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.slimripah.moringa.R;

public class MainActivity extends AppCompatActivity {

    //variables
    private static final int SPLASH_TIMER = 5000;

    ImageView logo;
    TextView powered;
    Animation fade;
    Animation drop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //hooks
        logo = findViewById(R.id.logo);
        powered = findViewById(R.id.powered);

        //animations
        fade = AnimationUtils.loadAnimation(this, R.anim.fadein_anim);
        drop = AnimationUtils.loadAnimation(this, R.anim.drop_anim);

        //set animation
        logo.setAnimation(fade);
        powered.setAnimation(drop);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }, SPLASH_TIMER);

    }
}