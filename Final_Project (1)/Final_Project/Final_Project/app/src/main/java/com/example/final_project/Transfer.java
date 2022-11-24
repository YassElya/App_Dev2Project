package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Transfer extends AppCompatActivity {
EditText Btext, Rtext, Stext, AmountText;
Button trans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        trans=findViewById(R.id.button3);
        Btext=findViewById(R.id.textView18);
        Rtext=findViewById(R.id.textView19);
        Stext=findViewById(R.id.textView20);
        AmountText=findViewById(R.id.textView21);
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double balance=Double.parseDouble(Btext.getText().toString());
                double Amount=Double.parseDouble(AmountText.getText().toString());
                if(balance<Amount){
                    Toast.makeText(Transfer.this, "You don't have enough funds to transfer.", Toast.LENGTH_SHORT).show();
                }else{
                    double result=balance-Amount;
                    Toast.makeText(Transfer.this, "result: "+result, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}