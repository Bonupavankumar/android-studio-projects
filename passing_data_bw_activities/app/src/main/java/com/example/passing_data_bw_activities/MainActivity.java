package com.example.passing_data_bw_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nameText,ageText;
    private Button button;
    private String name;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = findViewById(R.id.mName);
        ageText = findViewById(R.id.mAge);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
    }
    public void sendData()
    {
        name = nameText.getText().toString().trim();
        age = Integer.parseInt(ageText.getText().toString().trim());


        Intent i = new Intent(MainActivity.this,SecondActivity.class);
        i.putExtra(SecondActivity.AGE,age);
        i.putExtra(SecondActivity.AGE,age);

        startActivity(i);
    }

}