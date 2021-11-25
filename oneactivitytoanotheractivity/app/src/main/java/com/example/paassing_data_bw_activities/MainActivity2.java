package com.example.paassing_data_bw_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView name, reg, email, contact, address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.tvName2);
        reg = findViewById(R.id.tvReg2);
        email = findViewById(R.id.tvEmail2);
        contact = findViewById(R.id.tvContact2);
        address = findViewById(R.id.tvContact2);

        String userName = getIntent().getStringExtra("keyname");
        String userReg = getIntent().getStringExtra("keyreg");
        String userEmail = getIntent().getStringExtra("keyemail");
        String userContact = getIntent().getStringExtra("keycontact");
        String userAddress = getIntent().getStringExtra("keyaddress");

        name.setText(userName);
        reg.setText(userReg);
        email.setText(userEmail);
        contact.setText(userContact);
        address.setText(userAddress);
    }
}