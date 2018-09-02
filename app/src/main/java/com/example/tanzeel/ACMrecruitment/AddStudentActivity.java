package com.example.tanzeel.ACMrecruitment;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudentActivity extends AppCompatActivity {

    public final String TAG="ACM-recruitments";

    private EditText nameEditText;
    private EditText phoneEditText;
    private Student mStudent;

    private String name;
    private String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        Log.d(TAG,"onCreate() called.");

        nameEditText=(EditText)findViewById(R.id.nameEditText);
        phoneEditText=(EditText)findViewById(R.id.phoneNoEditText);

        nameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {



                return false;
            }
        });

        phoneEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {



                //TODO:make this better UI and UX check conditions


                    addStudent();

                return false;
            }
        });


    }

    private void addStudent()
    {
        Log.d(TAG,"addStudent() called.");

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Data").child("Students");

        Log.d("ACM-recruitments","FirebaseReference:"+databaseReference);

        name=nameEditText.getText().toString();
        phoneNo=phoneEditText.getText().toString();

        mStudent=new Student(name,phoneNo);

        Log.d(TAG,"Adding Name:"+mStudent.getName()+"\tPhone No:"+mStudent.getPhoneNo());

        databaseReference.push().setValue(mStudent);

        addStudentToLists();

        new AlertDialog.Builder(this)
                .setMessage("Student Profile generated.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .show();


    }

    private void addStudentToLists()
    {
        Log.d(TAG,"addStudentToLists() called.");

        ListedStudent mListedStudent=new ListedStudent(mStudent.getName());

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Data").child("Lists");
        databaseReference.child("All").push().setValue(mListedStudent);

        return;
    }


}
