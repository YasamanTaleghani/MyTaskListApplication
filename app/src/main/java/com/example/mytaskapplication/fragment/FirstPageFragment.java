package com.example.mytaskapplication.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mytaskapplication.R;
import com.example.mytaskapplication.activity.ListActivity;

public class FirstPageFragment extends Fragment {

    public static final String EXTRA_USERNAME = "com.example.mytaskapplication.fragment." +
            "ExtraUsername";
    public static final String EXTRA_TASKNUMBER = "com.example.mytaskapplication.fragment." +
            "ExtraTasknumber";
    private EditText mUsername;
    private EditText mTasks;
    private Button mButtonSubmit;

    public FirstPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first_page, container, false);

        findView(view);


        return view;
    }


    private void findView(View view){
        mUsername = view.findViewById(R.id.username);
        mTasks = view.findViewById(R.id.task);
        mButtonSubmit = view.findViewById(R.id.submit);
    }

    private void setListeners(){
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListActivity.class);
                intent.putExtra(EXTRA_USERNAME,mUsername.getText().toString().trim());
                intent.putExtra(EXTRA_TASKNUMBER,mTasks.getText().toString().trim());
                startActivity(intent);
            }
        });
    }

}