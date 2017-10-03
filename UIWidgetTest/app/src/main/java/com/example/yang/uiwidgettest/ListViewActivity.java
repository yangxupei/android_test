package com.example.yang.uiwidgettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yang.uiwidgettest.Adapter.FruitAdapter;
import com.example.yang.uiwidgettest.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private final String TAG ="ListViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        String[] data = {"Apple", "Banana", "Orange", "Pear", "Grape", "中文", "Mango", "Cherry", "One",
                "Apple", "Banana", "Orange", "Pear", "Grape", "中文", "Mango", "Cherry", "One",
                "Apple", "Banana", "Orange", "Pear", "Grape", "中文", "Mango", "Cherry", "One"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListViewActivity.this, android.R.layout.simple_list_item_1, data);

        List<Fruit> fruitList = new ArrayList<>();
        initFruit(fruitList);
        FruitAdapter fruitAdapter = new FruitAdapter(ListViewActivity.this,R.layout.fruit_item,fruitList);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Fruit fruit = fruitList.get(i);
            Log.i(TAG, "onCreate: "+view);
            Log.i(TAG, "onCreate: "+adapterView);
            Toast.makeText(this,fruit.getName(),Toast.LENGTH_SHORT).show();
        });
    }

    private void initFruit(List<Fruit> fruitList){
        for (int i=0;i<20;i++){
            Fruit fruit = new Fruit("Apple"+i,R.drawable.img_01);
            fruitList.add(fruit);
        }
    }

}
