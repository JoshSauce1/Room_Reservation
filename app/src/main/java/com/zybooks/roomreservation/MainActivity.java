package com.zybooks.roomreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info, AccCreate;
    private Button Login;
    static int currentUser; //Holds the name of the person who logged in

    //Imports Lists from the sign up page
    AccountCreation obj = new AccountCreation();
    List<Users> arrAd = obj.userArr; //Holds all accounts




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        AccCreate = (TextView)findViewById(R.id.tvAccCreate);

        //Account Creation click event
        AccCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AccountCreation.class);
                startActivity(intent);
            }
        });

        //User and Pass Event
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    //User and Pass validation method
    private void validate(String userName, String userPassword){
        boolean foundMatch = false;
        for(int i=0; i<arrAd.size(); i++) {
            Users model = arrAd.get(i);
            String bUser = model.getUser();
            String bPass = model.getPass();
            String btype = model.getUserType();

            if((userName.equals(bUser)) && (userPassword.equals(bPass))){
                currentUser = i;
                foundMatch = true;
                if (btype.equals("Regular")) {
                    Intent intent = new Intent(MainActivity.this, UserFeatures.class);
                    startActivity(intent);
                } else if (btype.equals("Admin")) {
                    Intent intent = new Intent(MainActivity.this, AdminFeatures.class);
                    startActivity(intent);
                }
                break; // Exit loop since we found a match
            }
        }
        if (!foundMatch) {
            Info.getVisibility();
            Info.setVisibility(View.VISIBLE);
        }
    }


}