package com.example.batteryinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView batteryinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryinfo=(TextView)findViewById(R.id.info);

        registerReceiver(this.batteryInfoReciever, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }
    BroadcastReceiver batteryInfoReciever=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int health=intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            int plugged=intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
            int status=intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);
            boolean present=intent.getExtras().getBoolean(BatteryManager.EXTRA_PRESENT);
            String technology=intent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);
            int temperature=intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);
            int voltage=intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,0);

            batteryinfo.setText("Health:"+health+"\n"+
                    "Level:"+level+" conditional\n"+
                    "Plugged:"+plugged+"\n"+
                    "Status:"+status+"\n"+
                    "Present:"+present+"\n"+
                    "Technology:"+technology+"\n"+
                    "Temperature:"+temperature+"\n"+
                    "Voltage:"+voltage+"\n");



        }
    };
}