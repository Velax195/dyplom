package com.kszych.testowa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MIN_VAL = 0;
    private static final int MAX_VAL = 100;

    public static final String CROSS_ACTIVITY_MESSAGE = "thisisnumber";

    private EditText etInput;
    private Button btGoToNext;
    private TextView tvLabel;

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (EditText) findViewById(R.id.etOnlyNumbers);
        btGoToNext = (Button) findViewById(R.id.btGoToSecond);
        tvLabel = (TextView) findViewById(R.id.tvOnlyNumbersLabel);

        tvLabel.setText(getString(R.string.input_numbers_label, MIN_VAL, MAX_VAL));

        btGoToNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean passed = false;
                try {
                    int input = Integer.parseInt(etInput.getText().toString());
                    if(isInRange(MIN_VAL, MAX_VAL, input)) {
                        // TODO go to second activity
                        Toast.makeText(view.getContext(), "Test passed", Toast.LENGTH_SHORT).show();
                        passed = true;
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra(CROSS_ACTIVITY_MESSAGE, input);
                        startActivity(intent);
                    }
                }
                catch (NumberFormatException e) {
                    // ignored
                }

                if(!passed) {
                    Toast.makeText(view.getContext(), "Test failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    /**
     * Checks if parameter is in given range. It is safe to revert min and values.
     *
     * @param min minimum value, inclusive
     * @param max maximum value, inclusive
     * @param value value to be checked
     * @return {@code true} if value is in range, {@code false} otherwise
     */
    private boolean isInRange(int min, int max, int value) {
        return max > min ? value >= min && value <= max : value >= max && value <= min;
    }

}
