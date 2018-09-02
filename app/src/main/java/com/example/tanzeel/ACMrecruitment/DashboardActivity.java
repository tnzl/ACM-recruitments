package com.example.tanzeel.ACMrecruitment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    private Button allStudentListButton;
    private Button addStudentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        allStudentListButton=(Button)findViewById(R.id.allStudentListButton);
        addStudentButton=(Button)findViewById(R.id.addStudentButton);

        allStudentListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listActivityIntent=new Intent(getApplicationContext(),ListActivity.class);
                listActivityIntent.putExtra("ListName","All");
                startActivity(listActivityIntent);
            }

        });

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listActivityIntent=new Intent(getApplicationContext(),AddStudentActivity.class);
                listActivityIntent.putExtra("ListName","All");
                startActivity(listActivityIntent);

            }
        });




    }
}
