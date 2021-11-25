package com.example.question5_module3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.etUserName);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = uname.getText().toString().trim();
                String userPassword = password.getText().toString().trim();
                validate(username,userPassword);
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("pavan")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("keyname", "Successfully Logged In");
            startActivity(intent);
        }
        else
        {

            new AlertDialog.Builder(MainActivity.this)
                    .setIcon(R.drawable.ic_baseline_warning_24)
                    .setTitle("Warning")
                    .setMessage("Username or Password is invalid")
                    .setNeutralButton("Help", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();

        }
    }
}