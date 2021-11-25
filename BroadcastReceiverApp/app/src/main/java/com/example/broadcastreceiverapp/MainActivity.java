package com.example.broadcastreceiverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter("com.codingpursuits.myBroadcastMessage");
        MyBroadcastReceiver objReceiver = new MyBroadcastReceiver();
        registerReceiver(objReceiver,intentFilter);

    }
}