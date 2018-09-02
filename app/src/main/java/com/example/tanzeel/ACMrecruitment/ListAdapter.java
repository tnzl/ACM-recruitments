package com.example.tanzeel.ACMrecruitment;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter{

    private Activity mActivity;
    private DatabaseReference mDatabaseReference;
    private ArrayList<DataSnapshot> mList;
    private ChildEventListener mChildEventListener=new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            mList.add(dataSnapshot);
            notifyDataSetChanged();

        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    class ViewHolder
    {
        private TextView name;
        private TextView round;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public DataSnapshot getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null)
        {
            LayoutInflater inflater=(LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.row_list,viewGroup,false);

            ViewHolder viewHolder=new ViewHolder();
            viewHolder.name=view.findViewById(R.id.nameTextView);
            viewHolder.round=view.findViewById(R.id.roundNoTextView);

            view.setTag(viewHolder);
        }

        ListedStudent listedStudent=getItem(i).getValue(ListedStudent.class);

        ViewHolder viewHolder=(ViewHolder)view.getTag();

        viewHolder.name.setText(listedStudent.getName());
        viewHolder.round.setText("0");



        return view;
    }

    public ListAdapter(Activity activity, DatabaseReference databaseReference) {
        mActivity = activity;
        mDatabaseReference = databaseReference;
        mList = new ArrayList<>();
        mDatabaseReference.addChildEventListener(mChildEventListener);
    }

    public void cleanup()    {
        Log.d("ACM-recruitments","ChatListAdapter.cleanup() called.");
        mDatabaseReference.removeEventListener(mChildEventListener);
    }
}
