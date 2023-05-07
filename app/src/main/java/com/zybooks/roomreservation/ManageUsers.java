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

public class ManageUsers extends AppCompatActivity {

    private EditText name, lastname, username, password;
    private Button makeChanges, delete;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_users);

        // Initialize UI elements
        listView = findViewById(R.id.lvSelectUsers);
        name = findViewById(R.id.etNewName);
        lastname = findViewById(R.id.editTextTextPersonName2);
        username = findViewById(R.id.etNewUserName);
        password = findViewById(R.id.etNewPass);
        makeChanges = findViewById(R.id.btnMakeChanges);
        delete = findViewById(R.id.btnDelete);

        List<Users> arrAd = AccountCreation.userArr;  // List of Users

        // Add Users to ListView
        List<String> nubilee = new ArrayList<String>();
        for (Users model : arrAd) {
            String bUser = model.getUser();
            String bType = model.getUserType();
            if (!bType.equals("Admin")) { // Check if user is not an admin
                nubilee.add(bUser);
                System.out.println(bUser);
            }
        }

        // Populate ListView with Regular Users
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nubilee);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item
                String selectedUsername = (String) parent.getItemAtPosition(position);

                // Set background color
                for (int i = 0; i < listView.getChildCount(); i++) {
                    if (position == i) {
                        listView.getChildAt(i).setBackgroundColor(Color.parseColor("#D3D3D3"));
                    } else {
                        listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }

                // Find the corresponding user object
                makeChanges.setOnClickListener(e -> {
                    for (Users user : arrAd) {
                        if (user.getUser().equals(selectedUsername)) {
                            user.setFirst(name.getText().toString());
                            user.setLast(lastname.getText().toString());
                            user.setPass(password.getText().toString());
                            user.setUser(username.getText().toString());

                            // Go to the admin features page
                            Intent intent = new Intent(ManageUsers.this, AdminFeatures.class);
                            startActivity(intent);
                        }
                    }
                });

                delete.setOnClickListener(d -> {
                    for (Users user : arrAd) {
                        if (user.getUser().equals(selectedUsername)) {
                            arrAd.remove(user); // Remove the selected user from the list

                            // Go to the admin features page
                            Intent intent = new Intent(ManageUsers.this, AdminFeatures.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        });
    }
}
