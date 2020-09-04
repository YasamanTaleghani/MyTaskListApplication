package com.example.mytaskapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mytaskapplication.R;

public class FirstPageActivity extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "com.example.mytaskapplication.fragment." +
            "ExtraUsername";
    public static final String EXTRA_TASKNUMBER = "com.example.mytaskapplication.fragment." +
            "ExtraTasknumber";
    private EditText mUsername;
    private EditText mTasks;
    private Button mButtonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        setListeners();

    }

    private void findView(){
        mUsername = findViewById(R.id.username);
        mTasks = findViewById(R.id.task);
        mButtonSubmit = findViewById(R.id.submit);
    }

    private void setListeners(){
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstPageActivity.this ,
                        ListActivity.class);
                intent.putExtra(EXTRA_USERNAME,mUsername.getText().toString().trim());
                intent.putExtra(EXTRA_TASKNUMBER,mTasks.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
}