package com.example.final_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    TextView t10, t14, t15, t16;
    ImageButton btn1, btn2, btn3;

    private int currentBalance;

    private ArrayList<String> arrayListTransactions;
    private ArrayAdapter<String> arrayAdapterTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        currentBalance=0;

        arrayListTransactions =new ArrayList<>();
        arrayAdapterTransactions = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, arrayListTransactions);

        ListView listView= (ListView) findViewById(R.id.listViewTransaction);
        listView.setAdapter(arrayAdapterTransactions);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() ==R.id.menuDeposit){

            Toast.makeText(this, "Deposit menu is selected ", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(getApplication(), DeposityActivity.class);
            startActivityForResult(intent, 1);

        }else if(item.getItemId() ==R.id.menuWithdraw){
            Toast.makeText(this, "Withdraw menu is selected ", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(getApplication(), WithdrawActivity.class);
            startActivityForResult(intent, 2);

        }else if(item.getItemId() ==R.id.menuTransactions){
            Toast.makeText(this, "Transaction menu is selected ", Toast.LENGTH_SHORT).show();

        }else if(item.getItemId() ==R.id.menuAbout){
            Toast.makeText(this, "About menu is selected ", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(getApplication(), About.class);
            intent.putExtra("developer", "Yassine Top G");
            startActivity(intent);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int amount = data.getExtras().getInt("amount");

        if(requestCode ==1){
            currentBalance +=amount;
            arrayAdapterTransactions.add("+ $"+ amount);

            Toast.makeText(this, "Depositing $ "+ amount, 0).show( );
        }else if(requestCode ==2){
            currentBalance-=amount;
            arrayAdapterTransactions.add("- $" +amount);
            Toast.makeText(this, "Withdrawing $"+ amount, 0).show();
        }

        TextView textViewCurrentBalance= (TextView) findViewById(R.id.textViewCurrentBalance);
        textViewCurrentBalance.setText("Current Balance: $"+currentBalance);
    }
}