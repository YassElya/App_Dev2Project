package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,passw;
    TextView noAccount;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Bank Transactions");

        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editTextTextPersonName);
        passw = findViewById(R.id.editTextTextPersonName2);
        noAccount = findViewById(R.id.textView5);

        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterPage.class);
                startActivity(i);
            }
        });
        login = findViewById(R.id.button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelperRegister mydb = new DatabaseHelperRegister(getApplicationContext());

                Intent intent= new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
//                if (!mydb.getUserLogins().isEmpty()) {
//                    for (Logins login : mydb.getUserLogins()) {
//                        if (login.getUsername().equals(username.getText().toString()) && login.getPassowrd().equals(passw.getText().toString())) {
//                            Intent intent = new Intent(getApplicationContext(), HomePage.class);
//                            startActivity(intent);
//                        }
//                    }
//
//                } else {
//                    Toast.makeText(MainActivity.this, "Can't login in this page", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}