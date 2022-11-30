package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Branch extends AppCompatActivity {
    EditText source, destination;
    Button track, main, logout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        source = findViewById(R.id.editTextTextPersonName);
        destination = findViewById(R.id.editTextTextPersonName2);
        track = findViewById(R.id.trackButton);
        main = findViewById(R.id.mainPage);
        logout = findViewById(R.id.logout);

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String src = source.getText().toString().trim();
                String des = destination.getText().toString().trim();
                DisplayTrack(src, des);
            }

            private void DisplayTrack(String src, String des) {
                try {
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + src + "/" + des);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }catch (ActivityNotFoundException e){

                }
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}