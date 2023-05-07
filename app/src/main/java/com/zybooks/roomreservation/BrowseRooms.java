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

public class BrowseRooms extends AppCompatActivity {
    // Declaring the necessary UI elements
    private Button reserveRoom, goBack;
    private ListView browseRooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_rooms); // Setting the layout for this activity

        // Initializing UI elements by finding them in the layout using their IDs
        reserveRoom = findViewById(R.id.btnReserveRoom);
        goBack = findViewById(R.id.btnGoBack);
        browseRooms = findViewById(R.id.lvUsersBR);

        List<Rooms> roomsAd = AddRooms.roomArr; // List of Rooms
        List<Users> usersAd = AccountCreation.userArr;
        int currUser = MainActivity.currentUser;

        // Create a list of strings to hold room information for display in the ListView
        List<String> nubilee = new ArrayList<String>();
        for (Rooms model : roomsAd) {
            String bBuilding = model.getBuildingName();
            String bRoom = model.getroomNumber();

            nubilee.add(bBuilding + ", Room: " + bRoom);
            System.out.println(bBuilding + ", Room: " + bRoom);
        }

        // Populate the ListView with room information
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nubilee);
        browseRooms.setAdapter(adapter);

        browseRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item
                String selectedUsername = (String) parent.getItemAtPosition(position);

                // Set background color
                for (int i = 0; i < browseRooms.getChildCount(); i++) {
                    if (position == i) {
                        browseRooms.getChildAt(i).setBackgroundColor(Color.parseColor("#D3D3D3"));
                    } else {
                        browseRooms.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }

                reserveRoom.setOnClickListener(view1 -> {
                    Users user = usersAd.get(currUser); // Get Users object at index i
                    String firstName = user.getFirstName(); // Get first name
                    String lastName = user.getLastName(); // Get last name

                    for (Rooms room : roomsAd) {
                        if ((room.getBuildingName() + ", Room: " + room.getroomNumber()).equals(selectedUsername)) {

                            room.setName(firstName + " " + lastName);

                            // Go to the user features page
                            Intent intent = new Intent(BrowseRooms.this, UserFeatures.class);
                            startActivity(intent);
                        }

                    }
                });

                // Go back to the UserFeatures activity
                goBack.setOnClickListener(view1 -> {
                    Intent intent = new Intent(BrowseRooms.this, UserFeatures.class);
                    startActivity(intent);
                });
            }
        });
    }
}
