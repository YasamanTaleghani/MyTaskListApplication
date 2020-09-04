package com.example.mytaskapplication.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytaskapplication.R;

public class FirstPageActivity extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "com.example.mytaskapplication.ExtraUsername";
    public static final String EXTRA_TASK_NUMBER = "com.example.mytaskapplication.ExtraTasknumber";
    private EditText mUsername;
    private EditText mTasks;
    private Button mButtonSubmit;

    public FirstPageActivity() {
    }

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

                if (mUsername==null || mTasks==null){
                    Toast.makeText(FirstPageActivity.this, "Fields cannot be empty.",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(FirstPageActivity.this ,
                            ListActivity.class);
                    intent.putExtra(EXTRA_USERNAME,mUsername.getText().toString().trim());
                    intent.putExtra(EXTRA_TASK_NUMBER,mTasks.getText().toString().trim());
                    startActivity(intent);
                }

            }
        });
    }
}