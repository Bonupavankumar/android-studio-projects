package com.example.broadcastsendercustom;

import android.content.BroadcastReceiver;
import android.content.Context; // has sendBroadcast(Intent) method
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void sendBroadcastMessage(View v) {
        final String CUSTOM_BROADCAST = "com.example.EXAMPLE_ACTION";
        //Intent intent = new Intent("com.example.EXAMPLE_ACTION");
        Intent intent = new Intent(CUSTOM_BROADCAST);
        intent.putExtra("com.example.EXTRA_TEXT", "Broadcast received");
        sendBroadcast(intent); // defined in Context class
    }
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String receivedText = intent.getStringExtra("com.example.EXTRA_TEXT");
            textView.setText(receivedText);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter("com.example.EXAMPLE_ACTION");
        registerReceiver(broadcastReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}