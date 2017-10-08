package com.kszych.testowa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    private TextView tvValue;

    private int iCurrentVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvValue = (TextView) findViewById(R.id.tvSecondContent);

        if(getIntent().getExtras() != null) {
            iCurrentVal = getIntent().getExtras().getInt(MainActivity.CROSS_ACTIVITY_MESSAGE, 0);
        }
        else {
            iCurrentVal = 0;
        }

        tvValue.setText(getString(R.string.single_digit, iCurrentVal));

            }
}
