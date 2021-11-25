package com.example.passing_data_bw_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
  public static final String NAME = "NAME";
  public static final String AGE = "AGE";
  private TextView nameText,ageTextView;
  private String name;
  private int age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        nameText = findViewById(R.id.mName);
        ageTextView = findViewById(R.id.mAge);


        Intent i = getIntent();
        name = i.getStringExtra(NAME);
        age  = i.getIntExtra(AGE, 0);


        nameText.setText("Hi !"+name);
        ageTextView.setText("Your Age is "+age);
    }
}