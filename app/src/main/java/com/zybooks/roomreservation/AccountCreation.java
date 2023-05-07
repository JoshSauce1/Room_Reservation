package com.zybooks.roomreservation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import java.util.ArrayList;
import java.util.List;

public class AccountCreation extends AppCompatActivity {

    // Declaring the necessary UI elements
    private EditText Username, Password, FirstName, LastName;
    private RadioButton Admin;
    private Button Create;

    // Creating a list to hold all users
    public static List<Users> userArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // Setting the layout for this activity

        // Initializing UI elements by finding them in the layout using their IDs
        Username = (EditText)findViewById(R.id.etUsername);
        Password = (EditText)findViewById(R.id.etSuPassword);
        FirstName = (EditText)findViewById(R.id.etPName);
        LastName = (EditText)findViewById(R.id.etPLastName);
        Admin = (RadioButton)findViewById(R.id.rbAdmin);
        Create = (Button)findViewById(R.id.btnSU);

        // Setting a click listener for the "Create" button
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Admin.isChecked()) {
                    // If the "Admin" radio button is checked, create a new user with "Admin" role
                    userArr.add(new Users(FirstName.getText().toString(), LastName.getText().toString(),
                            Username.getText().toString(), Password.getText().toString(), "Admin"));
                    // Create an intent to navigate back to the Login page
                    Intent intent = new Intent(AccountCreation.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // If the "Admin" radio button is not checked, create a new user with "Regular" role
                    userArr.add(new Users(FirstName.getText().toString(), LastName.getText().toString(),
                            Username.getText().toString(), Password.getText().toString(), "Regular"));
                    // Create an intent to navigate back to the Login page
                    Intent intent = new Intent(AccountCreation.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
