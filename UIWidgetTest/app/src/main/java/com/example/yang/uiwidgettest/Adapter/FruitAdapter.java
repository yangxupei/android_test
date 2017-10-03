package com.example.yang.uiwidgettest.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yang.uiwidgettest.R;
import com.example.yang.uiwidgettest.model.Fruit;

import java.util.List;


public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(@NonNull Context context, @LayoutRes int resource, List<Fruit> objects) {
        super(context, resource,objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView textView = view.findViewById(R.id.fruit_name);
        ImageView imageView = view.findViewById(R.id.fruit_image);
        imageView.setImageResource(fruit.getImgId());
        textView.setText(fruit.getName());
        return view;
    }
}
