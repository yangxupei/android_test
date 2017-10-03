package com.example.yang.acitivetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
//        Intent intent = getIntent();
//        String extra_data = intent.getStringExtra("extra_data");
//        Log.i(TAG, "onCreate: "+extra_data);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("data_result","Hello FirstActivity");
            setResult(RESULT_OK,intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_result","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }
}
