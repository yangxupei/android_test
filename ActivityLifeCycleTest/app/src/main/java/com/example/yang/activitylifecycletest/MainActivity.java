package com.example.yang.activitylifecycletest;

import android.content.Intent;
import android.net.MailTo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dialog = (Button) findViewById(R.id.start_dialog_activity);
        Button normal = (Button) findViewById(R.id.start_normal_activity);
        normal.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this,NormalActivity.class);
            startActivity(intent);
        });
        dialog.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,DialogActivity.class);
            startActivity(intent);
        });
        Log.i(TAG, "onCreate: ");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }
}
