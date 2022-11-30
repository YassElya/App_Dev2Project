package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {
EditText fname,mname,lname,sin,pw,cpw,username;
Button save;
DatabaseHelperRegister mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        fname=findViewById(R.id.editTextTextPersonName3);
        mname=findViewById(R.id.editTextTextPersonName4);
        lname=findViewById(R.id.editTextTextPersonName9);
        sin=findViewById(R.id.editTextTextPersonName10);
        pw=findViewById(R.id.editTextTextPersonName11);
        cpw=findViewById(R.id.editTextTextPersonName12);
        username=findViewById(R.id.editTextTextPersonName5);

        save=findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(!username.getText().toString().equals("") && !fname.getText().toString().equals("") && !lname.getText().toString().equals("") && !sin.getText().toString().equals("")
                         && !pw.getText().toString().equals("") && !cpw.getText().toString().equals("")
                         && pw.getText().toString().equals(cpw.getText().toString())){

                     mydb=new DatabaseHelperRegister(getApplicationContext());

                     mydb.addAccount(Integer.parseInt(sin.getText().toString()), username.getText().toString(),
                             pw.getText().toString(), fname.getText().toString(), lname.getText().toString(), mname.getText().toString(),cpw.getText().toString());

                     Intent i= new Intent(getApplicationContext(), MainActivity.class);
                     startActivity(i);
                 }else{
                        Toast.makeText(RegisterPage.this, "Your password doesn't match or you have some missing fields!", Toast.LENGTH_SHORT).show();
                     }
                 }
        });
    }
}








//    boolean isInserted = mydb.getUserLogins(username.getText().toString(),pw.getText().toString());

//if(username.getText().toString(),pw.getText().toString())
//                 if (isInserted == true) {
//                     Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
//                 } else {
//                     Toast.makeText(getApplicationContext(), "Data not Inserted ", Toast.LENGTH_SHORT).show();
//                 }
//                     Intent i=new Intent(getApplicationContext(),MainActivity.class);
//                     startActivity(i);








