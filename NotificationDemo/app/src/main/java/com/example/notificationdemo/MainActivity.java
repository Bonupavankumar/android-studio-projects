package com.example.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btNotification = findViewById(R.id.bt_notification);

        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = " This is a notification example.";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this
                )
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle("New Notification")
                .setContentText(message)
                .setAutoCancel(true);

                Intent intent = new Intent(MainActivity.this,
               NotificationActivity.class );
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message",message);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,
                        0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager)getSystemService(
                        Context.NOTIFICATION_SERVICE

                );
                notificationManager.notify(0,builder.build());
            }
        });
    }
}