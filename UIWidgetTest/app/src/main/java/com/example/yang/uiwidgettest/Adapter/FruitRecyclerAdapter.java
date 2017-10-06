package com.example.yang.uiwidgettest.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yang.uiwidgettest.R;
import com.example.yang.uiwidgettest.model.Fruit;

import java.util.List;


public class FruitRecyclerAdapter extends RecyclerView.Adapter<FruitRecyclerAdapter.ViewHolder> {

    private List<Fruit> fruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitName = itemView.findViewById(R.id.fruit_name);
            fruitImage = itemView.findViewById(R.id.fruit_image);
        }
    }

    public FruitRecyclerAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImgId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
