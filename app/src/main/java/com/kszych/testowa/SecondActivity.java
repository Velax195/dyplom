package com.kszych.testowa;

import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
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
    private Handler hdHandler;

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
        btDecrement = (Button) findViewById(R.id.btValDecrement);

        btIncrement.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        if(hdHandler!=null) return true;
                        hdHandler=new Handler();
                        hdHandler.postDelayed(rAction, 500);
                        break;
                    case MotionEvent.ACTION_UP:
                        if(hdHandler==null) return true;
                        hdHandler.removeCallbacks(rAction);
                        hdHandler=null;
                        break;
                }
                return false;
            }
            Runnable rAction = new Runnable() {
                @Override
                public void run() {
                    if (iCurrentVal<100)
                    {
                        iCurrentVal++;
                        tvValue.setText(getString(R.string.single_digit, iCurrentVal));
                    }
                    else
                    {
                        Toast.makeText(SecondActivity.this, "Upper limit reached" , Toast.LENGTH_SHORT).show();
                    }
                    hdHandler.postDelayed(this, 500);
                }
    };
});

        btDecrement.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        if(hdHandler!=null) return true;
                        hdHandler=new Handler();
                        hdHandler.postDelayed(rAction, 500);
                        break;
                    case MotionEvent.ACTION_UP:
                        if(hdHandler==null) return true;
                        hdHandler.removeCallbacks(rAction);
                        hdHandler=null;
                        break;
                }
                return false;
            }
            Runnable rAction = new Runnable() {
                @Override
                public void run() {
                    if (iCurrentVal>0)
                    {
                        iCurrentVal--;
                        tvValue.setText(getString(R.string.single_digit, iCurrentVal));
                    }
                    else
                    {
                        Toast.makeText(SecondActivity.this, "Upper limit reached" , Toast.LENGTH_SHORT).show();
                    }
                    hdHandler.postDelayed(this, 500);
                }
            };
        });


        }
    }

