package com.example.question5_module4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //PERMISSION
    private static final int MY_PERMISSIONS_REQUEST_RECEIVE_SMS = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CHECK IF THE PERMISSION IS NOT GRANTED
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            //if the permission is not been granted then check if the user has denied the permission
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.RECEIVE_SMS))
            {
                //Do nothing as user has denied
            }
            else
            {
                //a pop will appear asking for required permission i.e. Allow or Deny
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},MY_PERMISSIONS_REQUEST_RECEIVE_SMS);
            }
        }
    }//onCreate
    //after getting the result of permission requests the result will be passed through this method
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        //will check the request code
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_RECEIVE_SMS: {
                //check whether the length of grantResults is greater than 0 and is equal to PERMISSION_GRANTED
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Now broadcast receiver will work in background
                    Toast.makeText(this, "Thankyou for permitting!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Well I can't do anything untill you permit me ", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }
}