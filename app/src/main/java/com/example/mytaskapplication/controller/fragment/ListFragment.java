package com.example.mytaskapplication.controller.fragment;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytaskapplication.R;
import com.example.mytaskapplication.Repository.TaskRepository;
import com.example.mytaskapplication.model.Task;

import java.util.List;

import static android.widget.Toast.*;
import static com.example.mytaskapplication.controller.activity.FirstPageActivity.EXTRA_TASK_NUMBER;
import static com.example.mytaskapplication.controller.activity.FirstPageActivity.EXTRA_USERNAME;


public class ListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private TaskAdapter mTaskAdapter;
    private TaskRepository mRepository;
    private String username;
    private int tasksNumber;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState!=null){
            username= savedInstanceState.getString(EXTRA_USERNAME);
            tasksNumber = Integer.parseInt(savedInstanceState.getString(EXTRA_TASK_NUMBER));
            Toast.makeText(getActivity(), "Hi", LENGTH_SHORT).show();
        }

        mRepository = TaskRepository.getInstance(username,tasksNumber);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_list, container, false);
        Toast.makeText(getActivity(), "Hi", LENGTH_SHORT).show();
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

        if (mTaskAdapter == null) {
            mTaskAdapter = new TaskAdapter(tasks);
            mRecyclerView.setAdapter(mTaskAdapter);
        } else {
            mTaskAdapter.notifyDataSetChanged();
        }
    }

    private class TaskHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewTitle;
        private TextView mTextViewState;
        private Task mTask;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.task_Username);
            mTextViewState = itemView.findViewById(R.id.task_State);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = CrimePagerActivity.newIntent(getActivity(), mCrime.getId());
                    startActivity(intent);
                }
            });*/
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
            return 100;
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
        }
    }
}