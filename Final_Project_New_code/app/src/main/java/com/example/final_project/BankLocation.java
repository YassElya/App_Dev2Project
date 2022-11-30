package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BankLocation extends AppCompatActivity {
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_location);

        SupportMapFragment mapFragment =  (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);
    }

    public void OnMapReady(GoogleMap googleMap){
        map=googleMap;

        LatLng bank= new LatLng(54.9765498,-65.56748393);
        map.addMarker(new MarkerOptions().position(bank).title("bank"));
        map.moveCamera(CameraUpdateFactory.newLatLng(bank));
    }
}