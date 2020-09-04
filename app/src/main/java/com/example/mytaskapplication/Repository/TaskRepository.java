package com.example.mytaskapplication.Repository;

import com.example.mytaskapplication.States;
import com.example.mytaskapplication.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository {
    private String mString;
    private int mInt;
    private static final int TASK_SIZE = 100;
    private static TaskRepository sInstance;

    public static TaskRepository getInstance(String name, int taskNumber) {
        if (sInstance == null) {
            sInstance = new TaskRepository(name, taskNumber);
        }

        return sInstance;
    }

    private List<Task> mTasks;

    private TaskRepository(String name, int taskNumber) {

        mTasks = new ArrayList<>();
        for (int i = 0; i < taskNumber ; i++) {
            Task task = new Task();
            task.setTitle(name);
            task.setStates(States.Doing);

            mTasks.add(task);
        }
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setTasks(List<Task> tasks) {
        mTasks = tasks;
    }


    public Task getTask(UUID id) {
        for (Task task: mTasks) {
            if (task.getId().equals(id))
                return task;
        }

        return null;
    }

    public int getPosition(UUID taskId) {
        for (int i = 0; i < mTasks.size(); i++) {
            if (mTasks.get(i).getId().equals(taskId))
                return i;
        }

        return 0;
    }
}
