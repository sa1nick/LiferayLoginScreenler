package com.enprowess.liferayloginscreenlet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        // Retrieve the data from the intent
        Intent intent = getIntent();
        String userEmail = intent.getStringExtra("userEmail");
        String userScreenName = intent.getStringExtra("userScreenName");

        // Display the user details (you can use a TextView or any other UI element)
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView screenNameTextView = findViewById(R.id.screenNameTextView);

        emailTextView.setText(userEmail);
        screenNameTextView.setText(userScreenName);
    }
}