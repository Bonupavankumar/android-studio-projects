package com.example.alertdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = (Button) findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Create an alert dialog box
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        MainActivity.this);

                // Set alert title
                builder.setTitle(R.string.alerttitle);

                // Set the value for the positive reaction from the user
                // You can also set a listener to call when it is pressed
                builder.setPositiveButton(R.string.ok, null);

                // The message
                builder.setMessage(R.string.message);

                // Create the alert dialog and display it
                AlertDialog theAlertDialog = builder.create();
                theAlertDialog.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}