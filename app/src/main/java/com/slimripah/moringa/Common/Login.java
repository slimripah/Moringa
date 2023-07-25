package com.slimripah.moringa.Common;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.slimripah.moringa.R;

public class Login extends AppCompatActivity {
    private static final int RC_SIGN_IN = 1001; // Request code for sign-in


    private GoogleSignInClient mGoogleSignInClient; // Google sign-in client
    private ImageView googleBtn; // Google sign-in button
    private LottieAnimationView lottie; // Lottie animation view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lottie = findViewById(R.id.lottie);
        googleBtn = findViewById(R.id.google);

        // Configure sign-in to request the user's email address
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check if the user is already signed in
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            // User is already signed in, proceed to dashboard
            navigateToDashboard(account.getDisplayName()); // Proceed to dashboard activity
        }

        // Set click listener for the Google sign-in button
        googleBtn.setOnClickListener(v -> signIn());

    }

    // Method to initiate Google sign-in
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }

    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            if (account != null) {
                navigateToDashboard(account.getDisplayName());
            }
        } catch (ApiException e) {
            Toast.makeText(getApplicationContext(), "Failed to sign in", Toast.LENGTH_SHORT).show();
            Log.e("LoginActivity", "signInResult:failed code=" + e.getStatusCode());
        }
    }

    // Method to navigate to the Dashboard activity
    private void navigateToDashboard(String personName) {
        Intent intent = new Intent(Login.this, Dashboard.class);
        intent.putExtra("personName", personName); // Pass the user's name as an extra
        startActivity(intent);
        finish();
    }

}