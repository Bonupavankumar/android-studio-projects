package com.example.paassing_data_bw_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name,reg, email, contact,address;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.etName);
        reg = findViewById(R.id.etReg);
        email = findViewById(R.id.etEmail);
        contact = findViewById(R.id.etContact);
        address = findViewById(R.id.etAddress);
        submit = findViewById(R.id.btSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String userReg = reg.getText().toString();
                String userEmail = email.getText().toString();
                String userContact = contact.getText().toString();
                String userAddress = address.getText().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("keyname", userName);
                intent.putExtra("keyreg",userReg);
                intent.putExtra("keyemail",userEmail);
                intent.putExtra("keycontact",userContact);
                intent.putExtra("keyaddress",userAddress);
                startActivity(intent);
            }
        });
    }
}