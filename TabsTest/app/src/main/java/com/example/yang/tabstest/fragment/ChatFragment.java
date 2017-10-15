package com.example.yang.tabstest.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yang.tabstest.MainActivity;
import com.example.yang.tabstest.R;
import com.example.yang.tabstest.adapter.ChatItemAdapter;
import com.example.yang.tabstest.chat.DividerItemDecoration;

public class ChatFragment extends Fragment {

    private final String TAG = "ChatFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: "+MainActivity.chatItemList.size());
        View view = inflater.inflate(R.layout.chat, container, false);
        RecyclerView chatRecyclerVew = view.findViewById(R.id.chat_recycler_view);
        chatRecyclerVew.addItemDecoration(new DividerItemDecoration(container.getContext(),DividerItemDecoration.VERTICAL_LIST));
        ChatItemAdapter chatItemAdapter = new ChatItemAdapter(MainActivity.chatItemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        chatRecyclerVew.setLayoutManager(linearLayoutManager);
        chatRecyclerVew.setAdapter(chatItemAdapter);
        chatItemAdapter.notifyDataSetChanged();
        return view;
    }
}
