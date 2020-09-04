package com.example.mytaskapplication.model;

import com.example.mytaskapplication.States;

import java.util.UUID;

public class Task {

    private String mTitle;
    private States mStates;
    private UUID mId;

    public Task() {
        mId = UUID.randomUUID();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public States getStates() {
        return mStates;
    }

    public void setStates(States states) {
        mStates = states;
    }

    public UUID getId() {
        return mId;
    }
}
