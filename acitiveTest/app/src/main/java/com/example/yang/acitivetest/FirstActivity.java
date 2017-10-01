package com.example.yang.acitivetest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button = (Button) findViewById(R.id.button1);
//        button.setOnClickListener(view -> Toast.makeText(FirstActivity.this,"click Button1",Toast.LENGTH_SHORT).show());
        //显式跳转 Intent
//        button.setOnClickListener(view -> {
//            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//            startActivity(intent);
//        });

        //隐式跳转 Intent
//        button.setOnClickListener(view -> {
//            Intent intent = new Intent("com.example.yang.acitivetest.ACTION_START");
//            startActivity(intent);
//        });

        //跳转页面
        button.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.baidu.com"));
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "you click addItem", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "you click removeItem", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
