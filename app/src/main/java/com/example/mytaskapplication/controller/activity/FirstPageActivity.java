package com.example.mytaskapplication.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytaskapplication.R;
import com.example.mytaskapplication.controller.fragment.FirstPageFragment;

import static com.example.mytaskapplication.controller.fragment.FirstPageFragment.EXTRA_TASK_NUMBER;
import static com.example.mytaskapplication.controller.fragment.FirstPageFragment.EXTRA_USERNAME;

public class FirstPageActivity extends AppCompatActivity {



    public FirstPageActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.firstPage_container);

        if (fragment == null) {
            FirstPageFragment firstPageFragment = FirstPageFragment.newInstance();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.firstPage_container, firstPageFragment).
                    commit();
        }
    }
}