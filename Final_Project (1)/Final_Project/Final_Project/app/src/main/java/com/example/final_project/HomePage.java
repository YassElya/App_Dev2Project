package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView t10, t14, t15, t16;
    ImageButton btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        t10 = findViewById(R.id.textView10);
        t14 = findViewById(R.id.textView14);
        t15 = findViewById(R.id.textView15);
        t16 = findViewById(R.id.textView16);

        btn1 = findViewById(R.id.imageButton);
        btn2 = findViewById(R.id.imageButton2);
        btn3 = findViewById(R.id.imageButton3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),PayBill.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Deposit.class);
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Transfer.class);
                startActivity(i);
            }
        });

    }
}