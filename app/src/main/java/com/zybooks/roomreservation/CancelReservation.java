package com.zybooks.roomreservation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class CancelReservation extends AppCompatActivity {
    // Declaring the necessary UI elements
    private Button cancelRoom, goBack;
    private ListView selectRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_reservation); // Setting the layout for this activity

        // Initializing UI elements by finding them in the layout using their IDs
        cancelRoom = findViewById(R.id.btnCancelReserve);
        goBack = findViewById(R.id.btnGoBackC);
        selectRoom = findViewById(R.id.lvSelectCRoom);

        List<Rooms> roomsAd = AddRooms.roomArr; // List of Rooms
        List<Users> usersAd = AccountCreation.userArr;

        if (usersAd != null) {
            int currUser = MainActivity.currentUser;

            Users user = usersAd.get(currUser); // Get Users object at index i
            String firstName = user.getFirstName(); // Get first name
            String lastName = user.getLastName(); // Get last name

            // Create a list of strings to hold the rooms reserved by the current user
            List<String> nubilee = new ArrayList<String>();
            for (Rooms model : roomsAd) {
                String modelName = model.getName();
                if (modelName != null && modelName.equals(firstName + " " + lastName)) {
                    String bBuilding = model.getBuildingName();
                    String bRoom = model.getroomNumber();

                    nubilee.add(bBuilding + ", Room: " + bRoom);
                }
            }

            // Populate the ListView with the rooms reserved by the current user
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

                    cancelRoom.setOnClickListener(view1 -> {
                        for (Rooms room : roomsAd) {
                            if ((room.getBuildingName() + ", Room: " + room.getroomNumber()).equals(selectedUsername)) {

                                room.setName(null);

                                // Go to the user features page
                                Intent intent = new Intent(CancelReservation.this, UserFeatures.class);
                                startActivity(intent);
                            }
                        }
                    });

                    goBack.setOnClickListener(view1 -> {
                        // Go back to the UserFeatures activity
                        Intent intent = new Intent(CancelReservation.this, UserFeatures.class);
                        startActivity(intent);
                    });
                }
            });
        }
    }
}
