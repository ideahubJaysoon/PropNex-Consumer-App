package com.example.propnexconsumerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mInstance;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mInstance = this;
        manager = getSupportFragmentManager();

//        changeFragment(new HomeV2Fragment(BottomNavigationActivity.this, getApplicationContext()));
    }

    public void changeFragment(Fragment fragment) {
        try {
            //  FragmentTransaction transaction = manager.beginTransaction();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frame_layout, fragment);
            transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
            transaction.commit();
        } catch (Exception e) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, fragment);
            transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
            transaction.commitAllowingStateLoss();
        }

    }
}