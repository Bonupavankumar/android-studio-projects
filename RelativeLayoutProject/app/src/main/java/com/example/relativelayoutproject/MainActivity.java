package com.example.relativelayoutproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText textView;
    private EditText textView3;
    private EditText textView2;
    private EditText textView5;
    private EditText textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (EditText) findViewById(R.id.textView);
        textView3 = (EditText) findViewById(R.id.textView3);
        textView2 = (EditText) findViewById(R.id.textView2);
        textView3 = (EditText) findViewById(R.id.textView5);
        textView6 = (EditText) findViewById(R.id.textView6);
    }
}