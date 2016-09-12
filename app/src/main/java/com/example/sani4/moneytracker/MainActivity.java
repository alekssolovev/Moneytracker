package com.example.sani4.moneytracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


/**
 * Created by sani4 on 11.09.16.
 */
public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Log.d(LOG_TAG, "onCreate()");

    }

    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart()");
    }


    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume()");
    }

    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause()");
    }

    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop()");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart()");
    }


    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy()");
    }





}
