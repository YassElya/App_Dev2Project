package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText username,passw;
TextView noAccount;
Button login;
DatabaseHelperRegister db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.editTextTextPersonName);
        passw=findViewById(R.id.editTextTextPersonName2);
        noAccount=findViewById(R.id.textView5);
        db=new DatabaseHelperRegister(this);
        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),RegisterPage.class);
                startActivity(i);
            }
        });
        login=findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginUsername = getIntent().getStringExtra("USER");
                String loginPassword = getIntent().getStringExtra("PASS");
                if(username.getText().toString().equals(loginUsername) && passw.getText().toString().equals(loginPassword)){
                    Intent i=new Intent(getApplicationContext(),HomePage.class);
//                    loginUsername ="Banking System";
//                    i.putExtra("USER", loginUsername);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Enter the valid inputs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}