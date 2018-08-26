package com.example.tanzeel.ACMrecruitment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private final double TYPE_TIME = 0.3;

    private EditText mPinInput_EditTextView;
    private ImageButton mEnterPin_Button;
    private TextView mHashtag_TextView;

    private String s;

    private Timer timer = new Timer();

    private String hashtag[] = {"Building the future!", "#Bit_By_Bit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPinInput_EditTextView = (EditText) findViewById(R.id.pin_editText);
        mEnterPin_Button = (ImageButton) findViewById(R.id.enterPin_Button);
        mHashtag_TextView = (TextView) findViewById(R.id.hashtag_TextView);


    }

    @Override
    protected void onResume() {
        super.onResume();



    }
}
