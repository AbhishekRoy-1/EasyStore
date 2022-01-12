package com.example.easystore.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.easystore.MainActivity;
import com.example.easystore.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        auth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);
        if (auth.getCurrentUser() != null) {
            progressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            Toast.makeText(this, "Please wait you are already logged in", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void registration(View view) {
        startActivity(new Intent(HomeActivity.this, Registration_Activity.class));
    }

    public void login(View view) {
        startActivity(new Intent(HomeActivity.this, Login_Activity.class));
    }
}
