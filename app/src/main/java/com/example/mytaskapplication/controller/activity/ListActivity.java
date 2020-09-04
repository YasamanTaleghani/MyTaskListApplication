package com.example.mytaskapplication.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mytaskapplication.R;

public class ListActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.list_container);

        if (fragment == null) {
            ListFragment listFragment = new ListFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.list_container, listFragment).
                    commit();

        }
    }
}