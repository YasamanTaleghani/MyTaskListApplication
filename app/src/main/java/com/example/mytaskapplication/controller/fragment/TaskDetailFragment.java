package com.example.mytaskapplication.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mytaskapplication.R;


public class TaskDetailFragment extends Fragment {

    private TextView mTextViewTaskName;
    private TextView mTextViewTaskState;

    public TaskDetailFragment() {
        // Required empty public constructor
    }

    public static TaskDetailFragment newInstance() {
        TaskDetailFragment fragment = new TaskDetailFragment();
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
        View view = inflater.inflate(R.layout.fragment_task_detail, container, false);

        findView(view);

        return view;
    }

    private void findView(View view){
        mTextViewTaskName = view.findViewById(R.id.task_Username);
        mTextViewTaskState = view.findViewById(R.id.task_State);
    }
}