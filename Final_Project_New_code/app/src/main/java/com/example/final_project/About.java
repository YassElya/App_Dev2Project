package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class About extends AppCompatActivity {

    Button logout, mainPage, branch, mainBranch;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Intent intent=getIntent();
        String dev= intent.getExtras().getString("developer");

        TextView textviewDeveloper= (TextView)findViewById(R.id.textviewDeveloper);
        textviewDeveloper.setText("Developed by: " + dev);

        logout=findViewById(R.id.logout);
        mainPage=findViewById(R.id.mainPage);
        branch=findViewById(R.id.branchSearch);
        mainBranch=findViewById(R.id.mainBranch);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        });

        branch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), Branch.class);
                startActivity(intent);
            }
        });

        mainBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), BankLocation.class);
                startActivity(intent);
            }
        });
    }
}