package com.example.registerationdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText RegisterationNo;
    private EditText EmailAddress;
    private EditText ContactNo;
    private EditText Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.Name);
        RegisterationNo=(EditText)findViewById(R.id.RegistrationNo);
        EmailAddress=(EditText)findViewById(R.id.EmailAddress);
        ContactNo=(EditText)findViewById(R.id.Contact);
        Address=(EditText)findViewById(R.id.Address);
    }
}