package com.zybooks.roomreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminFeatures extends AppCompatActivity {
    private Button goUsers, goRooms,addRooms, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_features);

        goUsers = findViewById(R.id.btnUsers);
        goRooms = findViewById(R.id.btnRooms);
        addRooms = findViewById(R.id.btnAddRoom);
        logout = findViewById(R.id.btnAdLogout);

        goUsers.setOnClickListener(view -> {
            //Goes to the ManageUsers page
            Intent intent = new Intent(AdminFeatures.this, ManageUsers.class);
            startActivity(intent);
        });
        goRooms.setOnClickListener(view -> {
            //Goes to the ManageRooms page
            Intent intent = new Intent(AdminFeatures.this, ManageRooms.class);
            startActivity(intent);
        });

        addRooms.setOnClickListener(view -> {
            //Goes to AddRooms page
            Intent intent = new Intent(AdminFeatures.this, AddRooms.class);
            startActivity(intent);
        });

        logout.setOnClickListener(view -> {
            //Goes to the login page
            Intent intent = new Intent(AdminFeatures.this, MainActivity.class);
            startActivity(intent);
        });
    }



}