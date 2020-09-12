package com.example.mytaskapplication.controller.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytaskapplication.R;
import com.example.mytaskapplication.Repository.TaskRepository;
import com.example.mytaskapplication.model.Task;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static android.widget.Toast.*;
import static com.example.mytaskapplication.controller.fragment.FirstPageFragment.EXTRA_TASK_NUMBER;
import static com.example.mytaskapplication.controller.fragment.FirstPageFragment.EXTRA_USERNAME;


public class ListFragment extends Fragment {

    public static final String USERNAME = "Username";
    public static final String TASK_NUMBER = "taskNumber";
    private RecyclerView mRecyclerView;
    private TaskAdapter mTaskAdapter;
    private TaskRepository mRepository;
    private LinearLayout row_linear_layout;
    private String username;
    private int tasksNumber;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(String username, String taskNumber) {

        Bundle args = new Bundle();
        args.putString(USERNAME,username);
        args.putString(TASK_NUMBER,taskNumber);
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        username = String.valueOf(getArguments().get(USERNAME));
        tasksNumber = Integer.parseInt( String.valueOf(getArguments().get(TASK_NUMBER)));
        mRepository = TaskRepository.getInstance(username, tasksNumber);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Toast.makeText(getActivity(), "HiOnCreateView", LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        findViews(view);
        initViews();

        return view;
    }

    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view_task_list);

    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
    }

    private void updateUI() {
        List<Task> tasks = mRepository.getTasks();
        mTaskAdapter = new TaskAdapter(tasks);
        mRecyclerView.setAdapter(mTaskAdapter);

    }

    private class TaskHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewTitle;
        private TextView mTextViewState;
        private LinearLayout row_linear_layout;
        private Task mTask;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.row_item_task_title);
            mTextViewState = itemView.findViewById(R.id.row_item_task_number);
            row_linear_layout = itemView.findViewById(R.id.row_linear_layout);

        }

        public void bindTask(Task task) {
            mTask = task;
            mTextViewTitle.setText(task.getTitle());
            mTextViewState.setText(task.getStates().toString());
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {

        private List<Task> mTasks;

        public List<Task> getTasks() {
            return mTasks;
        }

        public void setTasks(List<Task> tasks) {
            mTasks = tasks;
        }

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        @Override
        public int getItemCount() {
            //return mTasks.size();
            return mTasks.size();
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.fragment_task_detail, parent,
                    false);
            TaskHolder taskHolder = new TaskHolder(view);
            return taskHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {

            Task task = mTasks.get(position);
            holder.bindTask(task);
            if (position%2==0){
                holder.row_linear_layout.setBackgroundColor(Color.RED);
            } else
                holder.row_linear_layout.setBackgroundColor(Color.YELLOW);
        }
    }

}