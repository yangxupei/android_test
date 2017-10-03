package com.example.yang.uiwidgettest;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        //进度条
//        button.setOnClickListener(view ->{
//            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
//            int progress = progressBar.getProgress();
//            progressBar.setProgress(progress+10);
//        });

        //对话框
        button.setOnClickListener(view -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("this is dialog");
            dialog.setMessage("something  important.");
            dialog.setCancelable(false);
            dialog.setPositiveButton("OK", (d, w) -> {

            });
            dialog.setNegativeButton("CANCEL", (d, w) -> {

            });
            dialog.show();
        });
    }
}
