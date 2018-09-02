package com.example.tanzeel.ACMrecruitment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListActivity extends AppCompatActivity {

    private TextView populationTextView;
    private ListView mListView;
    private ListAdapter mListAdapter;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        populationTextView=(TextView)findViewById(R.id.listPoppulationTextView);
        mListView=(ListView)findViewById(R.id.studentList);

        Intent mIntent=getIntent();
        String listName=mIntent.getStringExtra("ListName");

        mDatabaseReference= FirebaseDatabase.getInstance().getReference().child("Data").child("Lists").child(listName);


        mListAdapter=new ListAdapter(this, mDatabaseReference);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mListView.setAdapter(mListAdapter);

    }
}
