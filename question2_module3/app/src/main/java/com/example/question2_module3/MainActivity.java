package com.example.question2_module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton cbTiger, cbJackal, cbBear, cbZebra;
    TextView tvOutput;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbTiger = findViewById(R.id.cb_tiger);
        cbJackal = findViewById(R.id.cb_jackal);
        cbBear = findViewById(R.id.cb_bear);
        cbZebra = findViewById(R.id.cb_zebra);
        tvOutput = findViewById(R.id.tv_output);
        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cb_tiger:
                        tvOutput.setBackgroundResource(R.drawable.img1);

                        break;
                    case R.id.cb_jackal:
                        tvOutput.setBackgroundResource(R.drawable.img2);

                        break;
                    case R.id.cb_bear:
                        tvOutput.setBackgroundResource(R.drawable.img3);

                        break;
                    case R.id.cb_zebra:
                        tvOutput.setBackgroundResource(R.drawable.img4);

                }
            }
        });
    }
}
