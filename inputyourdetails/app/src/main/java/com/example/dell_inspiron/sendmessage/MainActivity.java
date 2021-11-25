package com.example.dell_inspiron.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String message = getResources().getString(R.string.UserInput);

        final Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                Intent sendMessage = new Intent(MainActivity.this,     DisplayMessageActivity.class);
                sendMessage.putExtra("UserInput", message);
                startActivity(sendMessage);

            }
        });
    }
}