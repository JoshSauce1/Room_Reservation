// Importing required packages
package com.zybooks.roomreservation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ManageRooms extends AppCompatActivity {
    // Declaring the necessary UI elements
    private EditText buildingName, buildingNum, date, startTime, endTime;
    private Button makeChanges, delete;
    private ListView selectRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_rooms); // Setting the layout for this activity

        // Initializing UI elements by finding them in the layout using their IDs
        selectRoom = findViewById(R.id.lvSelectRoom);
        buildingName = findViewById(R.id.etNewBuildingName);
        buildingNum = findViewById(R.id.etNewRoomNum);
        date = findViewById(R.id.etNewDate);
        startTime = findViewById(R.id.etNewStartTime);
        endTime = findViewById(R.id.etNewEndTime);
        delete = findViewById(R.id.btnDeleteRoom);
        makeChanges = findViewById(R.id.btnMakeChangesRooms);
        List<Rooms> arrAd = AddRooms.roomArr; // List of Rooms

        // Add Rooms to ListView
        List<String> nubilee = new ArrayList<String>();
        for (Rooms model : arrAd) {
            String bBuilding = model.getBuildingName();
            String bRoom = model.getroomNumber();
            nubilee.add(bBuilding + ", Room: " + bRoom);
            System.out.println(bBuilding + ", Room: " + bRoom);
        }

        // Populate ListView with Room information
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nubilee);
        selectRoom.setAdapter(adapter);

        selectRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item
                String selectedUsername = (String) parent.getItemAtPosition(position);

                // Set background color
                for (int i = 0; i < selectRoom.getChildCount(); i++) {
                    if (position == i) {
                        selectRoom.getChildAt(i).setBackgroundColor(Color.parseColor("#D3D3D3"));
                    } else {
                        selectRoom.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }

                makeChanges.setOnClickListener(view1 -> {
                    for (Rooms room : arrAd) {
                        if ((room.getBuildingName() + ", Room: " + room.getroomNumber()).equals(selectedUsername)) {
                            room.setBuildingName(buildingName.getText().toString()); // Set the building name
                            room.setroomNumber(buildingNum.getText().toString()); // Set the room number
                            room.setDat(date.getText().toString()); // Set the date
                            room.setstartTime(startTime.getText().toString()); // Set the start time
                            room.setendTime(endTime.getText().toString()); // Set the end time

                            // Go to the admin features page
                            Intent intent = new Intent(ManageRooms.this, AdminFeatures.class);
                            startActivity(intent);
                        }
                    }
                });

                delete.setOnClickListener(view1 -> {
                    for (Rooms room : arrAd) {
                        if ((room.getBuildingName() + ", Room: " + room.getroomNumber()).equals(selectedUsername)) {
                            arrAd.remove(room); // Remove the selected room from the list

                            // Go to the admin features page
                            Intent intent = new Intent(ManageRooms.this, AdminFeatures.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        });
    }
}
