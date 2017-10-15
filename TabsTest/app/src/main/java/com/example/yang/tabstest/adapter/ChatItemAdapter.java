package com.example.yang.tabstest.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yang.tabstest.R;
import com.example.yang.tabstest.model.ChatItem;

import java.util.List;

/**
 * @author yang xp
 * @version V1.0
 * @date 2017/10/15 14:21
 */

public class ChatItemAdapter extends RecyclerView.Adapter<ChatItemAdapter.ViewHolder> {

    private List<ChatItem> chatItemList;

    private PopupWindow popupWindow;

    private View longSelectView;

    public ChatItemAdapter(List<ChatItem> chatItemList) {
        this.chatItemList = chatItemList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView chatItemImage;
        TextView chatItemContentHead;
        TextView chatItemContentDetail;
        LinearLayout linearLayout;

        ViewHolder(View itemView) {
            super(itemView);
            chatItemImage = itemView.findViewById(R.id.chat_item_image);
            chatItemContentHead = itemView.findViewById(R.id.chat_item_content_head);
            chatItemContentDetail = itemView.findViewById(R.id.chat_item_content_detail);
            linearLayout = itemView.findViewById(R.id.chat_item_content_layout);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.linearLayout.setOnClickListener(v -> {
            closePopupWindow();
            Toast.makeText(v.getContext(), "you click ", Toast.LENGTH_SHORT).show();
        });
        viewHolder.linearLayout.setOnLongClickListener(v -> {
            View popupView = LayoutInflater.from(v.getContext()).inflate(R.layout.chat_popup, null, false);
            closePopupWindow();
            popupWindow = new PopupWindow(v.getContext());
            popupWindow.setContentView(popupView);
            popupWindow.setWidth(400);
            popupWindow.setHeight(500);
            popupWindow.showAsDropDown(v);
            v.setBackgroundColor(Color.GRAY);
            longSelectView = v;
            return true;
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ChatItem chatItem = chatItemList.get(position);
        holder.chatItemContentHead.setText(chatItem.getContentTitle());
        holder.chatItemContentDetail.setText(chatItem.getContentDetail());
        holder.chatItemImage.setImageResource(chatItem.getImageId());
    }

    @Override
    public int getItemCount() {
        return chatItemList.size();
    }

    private void closePopupWindow() {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (longSelectView != null){
            longSelectView.setBackgroundColor(Color.WHITE);
        }
    }
}
