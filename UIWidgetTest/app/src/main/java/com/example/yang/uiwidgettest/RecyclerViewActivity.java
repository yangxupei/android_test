package com.example.yang.uiwidgettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.yang.uiwidgettest.Adapter.FruitRecyclerAdapter;
import com.example.yang.uiwidgettest.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cecycler_layout);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<Fruit> fruitList = new ArrayList<>();
        initFruit(fruitList);
        FruitRecyclerAdapter fruitRecyclerAdapter = new FruitRecyclerAdapter(fruitList);
        recyclerView.setAdapter(fruitRecyclerAdapter);
    }

    private void initFruit(List<Fruit> fruitList){
        for (int i=0;i<20;i++){
            Fruit fruit = new Fruit("Apple"+i,R.drawable.img_01);
            fruitList.add(fruit);
        }
    }
}
