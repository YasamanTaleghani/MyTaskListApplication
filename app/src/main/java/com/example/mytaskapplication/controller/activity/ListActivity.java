package com.example.mytaskapplication.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.widget.Toast;
import com.example.mytaskapplication.R;
import com.example.mytaskapplication.controller.fragment.ListFragment;

import static com.example.mytaskapplication.controller.fragment.FirstPageFragment.EXTRA_T;
import static com.example.mytaskapplication.controller.fragment.FirstPageFragment.EXTRA_TASK_NUMBER;
import static com.example.mytaskapplication.controller.fragment.FirstPageFragment.EXTRA_U;
import static com.example.mytaskapplication.controller.fragment.FirstPageFragment.EXTRA_USERNAME;

public class ListActivity extends AppCompatActivity {

    private String username;
    private String tasksNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        if (getIntent() != null) {
            username = getIntent().getStringExtra(EXTRA_USERNAME);
            tasksNumber = getIntent().getStringExtra(EXTRA_TASK_NUMBER);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        ListFragment listFragment = ListFragment.newInstance(username,tasksNumber);
        fragmentManager.beginTransaction().replace(R.id.list_container, listFragment).commit();

    }

}