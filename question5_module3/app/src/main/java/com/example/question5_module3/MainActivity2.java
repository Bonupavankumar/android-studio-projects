package com.example.question5_module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        success = findViewById(R.id.tvSuccess);
        String successMessage = getIntent().getStringExtra("keyname");
        success.setText(successMessage);
    }
}