package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeposityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposity);
    }

    public void buttonDeposit(View view){
        EditText editTextAmount= (EditText) findViewById(R.id.editTextDepositAmount);
        int depositAmount= 0;

        try{
            depositAmount =Integer.parseInt(editTextAmount.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "please enter a valid amount", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent= getIntent();
        intent.putExtra("amount", depositAmount);
        setResult(RESULT_OK, intent);
        finish();

    }
}