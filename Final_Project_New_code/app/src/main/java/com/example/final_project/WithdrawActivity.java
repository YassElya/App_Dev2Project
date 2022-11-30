package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WithdrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);
    }

    public void buttonWithdrawClick(View V){
        EditText editTextWithdrawAmount = (EditText) findViewById(R.id.editTextTextWithdraw);
        int amount=0;

        try {
            amount=Integer.parseInt(editTextWithdrawAmount.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "Please Enter a valid amount", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent= getIntent();
        intent.putExtra("amount", amount);

        setResult(RESULT_OK,intent);
        finish();
    }
}