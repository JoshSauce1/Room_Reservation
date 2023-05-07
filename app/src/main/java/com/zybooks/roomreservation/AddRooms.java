package com.zybooks.roomreservation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class AddRooms extends AppCompatActivity {

    // Declaring the necessary UI elements
    private EditText buildingName, roomNum, startTime, endTime, date, features;
    private Button makeChanges;

    // Creating a list to hold all rooms
    public static List<Rooms> roomArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rooms); // Setting the layout for this activity

        // Initializing UI elements by finding them in the layout using their IDs
        buildingName = (EditText)findViewById(R.id.etBuildingName);
        roomNum = (EditText)findViewById(R.id.etRoom);
        startTime = (EditText)findViewById(R.id.etStartTime2);
        endTime = (EditText)findViewById(R.id.etEndTime);
        date = (EditText)findViewById(R.id.Date);
        features = (EditText)findViewById(R.id.editTextTextPersonName5);
        makeChanges = (Button)findViewById(R.id.makeChanges);

        // Setting a click listener for the "makeChanges" button
        makeChanges.setOnClickListener(view -> {
            // Creating a new room object using the entered information
            roomArr.add(new Rooms(buildingName.getText().toString(), roomNum.getText().toString(), startTime.getText().toString(),
                    endTime.getText().toString(), date.getText().toString(), features.getText().toString()));

            // Creating an intent to navigate to the AdminFeatures activity
            Intent intent = new Intent(AddRooms.this, AdminFeatures.class);
            startActivity(intent);
        });
    }
}
