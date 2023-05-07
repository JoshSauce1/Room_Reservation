// Importing required packages
package com.zybooks.roomreservation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;

public class ManageInfo extends AppCompatActivity {
    // Declaring the necessary UI elements
    private EditText name, lastname, username, password;
    private Button makeChanges, goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_info); // Setting the layout for this activity

        // Initializing UI elements by finding them in the layout using their IDs
        name = findViewById(R.id.etUserName);
        lastname = findViewById(R.id.etUserLAst);
        username = findViewById(R.id.etUserNewUSer);
        password = findViewById(R.id.etUserNewPass);
        makeChanges = findViewById(R.id.btnUserMakeChanges);
        goBack = findViewById(R.id.btnUserGoBacl);
        List<Users> usersAd = AccountCreation.userArr; // List of Users
        int currUser = MainActivity.currentUser;

        // Update user information when the "makeChanges" button is clicked
        makeChanges.setOnClickListener(e -> {
            Users user = usersAd.get(currUser); // Get Users object at index i
            user.setFirst(name.getText().toString()); // Set the first name
            user.setLast(lastname.getText().toString()); // Set the last name
            user.setUser(username.getText().toString()); // Set the username
            user.setPass(password.getText().toString()); // Set the password

            // Go to the UserFeatures activity
            Intent intent = new Intent(ManageInfo.this, UserFeatures.class);
            startActivity(intent);
        });

        // Go back to the UserFeatures activity when the "goBack" button is clicked
        goBack.setOnClickListener(d -> {
            Intent intent = new Intent(ManageInfo.this, UserFeatures.class);
            startActivity(intent);
        });
    }
}
