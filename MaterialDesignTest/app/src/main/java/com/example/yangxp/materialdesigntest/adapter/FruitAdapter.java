package com.example.yangxp.materialdesigntest.adapter;


import android.app.backup.FullBackupDataOutput;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yangxp.materialdesigntest.FruitActivity;
import com.example.yangxp.materialdesigntest.R;
import com.example.yangxp.materialdesigntest.model.Fruit;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> fruitList;

    private Context context;

    public FruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null){
            context = parent.getContext();
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.fruit_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        viewHolder.cardView.setOnClickListener(view -> {
            int position = viewHolder.getAdapterPosition();
            Fruit fruit = fruitList.get(position);
            Intent intent = new Intent(context, FruitActivity.class);
            intent.putExtra(FruitActivity.FRUIT_NAME,fruit.getName());
            intent.putExtra(FruitActivity.FRUIT_IMAGE_ID,fruit.getImageId());
            context.startActivity(intent);
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.fruitName.setText(fruit.getName());
        Glide.with(context).load(fruit.getImageId()).into(holder.fruitImage);
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            fruitImage = itemView.findViewById(R.id.fruit_image);
            fruitName = itemView.findViewById(R.id.fruit_name);
        }
    }

}
