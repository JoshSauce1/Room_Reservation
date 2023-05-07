package com.zybooks.roomreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class UserFeatures extends AppCompatActivity {
    private Button browseRooms, cancelReservation, manageInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_features);

        // Initialize buttons
        browseRooms = findViewById(R.id.btnBR);
        cancelReservation = findViewById(R.id.btnCR);
        manageInfo = findViewById(R.id.btnMI);

        // Set click listeners for each button
        browseRooms.setOnClickListener(view -> {
            // Start BrowseRooms activity
            Intent intent = new Intent(UserFeatures.this, BrowseRooms.class);
            startActivity(intent);
        });

        cancelReservation.setOnClickListener(view -> {
            // Start CancelReservation activity
            Intent intent = new Intent(UserFeatures.this, CancelReservation.class);
            startActivity(intent);
        });

        manageInfo.setOnClickListener(view -> {
            // Start ManageInfo activity
            Intent intent = new Intent(UserFeatures.this, ManageInfo.class);
            startActivity(intent);
        });
    }
}
