package com.kszych.testowa;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    private TextView tvValue;

    private int iCurrentVal;

    private Button btIncrement;
    private Button btDecrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvValue = (TextView) findViewById(R.id.tvSecondContent);

        if (getIntent().getExtras() != null) {
            iCurrentVal = getIntent().getExtras().getInt(MainActivity.CROSS_ACTIVITY_MESSAGE, 0);
        } else {
            iCurrentVal = 0;
        }

        tvValue.setText(getString(R.string.single_digit, iCurrentVal));

        btIncrement = (Button) findViewById(R.id.btValIncrement);

        btIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iCurrentVal<100)
                {
                    iCurrentVal++;
                    tvValue.setText(getString(R.string.single_digit, iCurrentVal));
                }
                else
                {
                    Toast.makeText(SecondActivity.this, "Upper limit reached" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        btDecrement = (Button) findViewById(R.id.btValDecrement);

        btDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iCurrentVal>0)
                {
                    iCurrentVal--;
                    tvValue.setText(getString(R.string.single_digit, iCurrentVal));
                }
                else
                {
                    Toast.makeText(SecondActivity.this, "Lower limit reached" , Toast.LENGTH_SHORT).show();
                }
            }
        });
        btDecrement.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                    if (iCurrentVal > 0) {
                        iCurrentVal=0;
                        tvValue.setText(getString(R.string.single_digit, iCurrentVal));
                    } else {
                        Toast.makeText(SecondActivity.this, "Lower limit reached", Toast.LENGTH_SHORT).show();
                    }

                return true;
            }
        });

        }
    }

