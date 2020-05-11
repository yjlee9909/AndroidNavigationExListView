package com.example.androidnavigationexlistview.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidnavigationexlistview.R;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    Runnable runnable;

    @Override
    protected  void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, LoadingActivity.class));

                finish();
            }
        };
        //3초
        handler.postDelayed(runnable,2000);

    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(runnable);
        super.onDestroy();

    }



}
