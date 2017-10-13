package com.example.yangxp.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.yangxp.fragmenttest.fragment.RightFragment;

public class MainLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(view -> {
            switch (view.getId()){
                case R.id.button:
                    replaceFragment(new RightFragment());
                    break;
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right_fragment,fragment);
        fragmentTransaction.commit();
    }
}
