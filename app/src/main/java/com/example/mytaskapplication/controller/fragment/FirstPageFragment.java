package com.example.mytaskapplication.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytaskapplication.R;
import com.example.mytaskapplication.controller.activity.FirstPageActivity;
import com.example.mytaskapplication.controller.activity.ListActivity;

public class FirstPageFragment extends Fragment {

    public static final String EXTRA_USERNAME = "com.example.mytaskapplication.ExtraUsername";
    public static final String EXTRA_TASK_NUMBER = "com.example.mytaskapplication.ExtraTasknumber";
    public static final String EXTRA_U = "Extra_u";
    public static final String EXTRA_T = "Extra_t";
    private EditText mUsername;
    private EditText mTasks;
    private Button mButtonSubmit;

    public FirstPageFragment() {
        // Required empty public constructor
    }


    public static FirstPageFragment newInstance() {
        FirstPageFragment fragment = new FirstPageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_page, container, false);

        findView(view);
        setListeners();
        return view;
    }

    private void findView(View view){
        mUsername = view.findViewById(R.id.login_username);
        mTasks = view.findViewById(R.id.login_task);
        mButtonSubmit = view.findViewById(R.id.submit);
    }

    private void setListeners(){
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mUsername.length() == 0|| mTasks.length() == 0){
                    Toast.makeText(getActivity(), "Fields cannot be empty.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getActivity() , ListActivity.class);
                    intent.putExtra(EXTRA_USERNAME,mUsername.getText().toString().trim());
                    intent.putExtra(EXTRA_TASK_NUMBER,mTasks.getText().toString().trim());
                    startActivity(intent);
                }

            }
        });
    }

}