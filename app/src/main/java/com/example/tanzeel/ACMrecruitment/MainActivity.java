package com.example.tanzeel.ACMrecruitment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private final double TYPE_TIME = 0.3;
    public final String TAG="ACM-recruitment";
    public final String PASSWORD_PIN="4444";


    private EditText mPinInput_EditTextView;
    private ImageButton mEnterPin_Button;
    private TextView mHashtag_TextView;

    private final TextWatcher mEditTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.d(TAG,"beforeTextChanged \n"+"charSequence="+charSequence);

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.d(TAG,"onTextChanged \n"+"charSequence="+charSequence);

        }

        @Override
        public void afterTextChanged(Editable editable) {

            String k=editable.toString();

            Log.d(TAG,"afterTextChanged \n"+"charSequence="+k);


            if(k.length()==4)
            {
                if (k.equals(PASSWORD_PIN))
                {
                    Log.d(TAG, "PIN matched.");
                    Intent dashboardIntent = new Intent(MainActivity.this, DashboardActivity.class);

                    startActivity(dashboardIntent);
                    finish();
                }
                else
                {
                    Log.d(TAG, "PIN not matched.");
                    Toast.makeText(getApplicationContext(), "Wrong PIN !", Toast.LENGTH_SHORT).show();
                    mPinInput_EditTextView.setText("");
                }
            }

        }
    };

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

        mPinInput_EditTextView.addTextChangedListener(mEditTextWatcher);

    }

    @Override
    protected void onResume() {
        super.onResume();



    }
}
