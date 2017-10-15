package com.example.yang.tabstest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yang.tabstest.adapter.ChatItemAdapter;
import com.example.yang.tabstest.adapter.FragmentAdapter;
import com.example.yang.tabstest.fragment.ChatFragment;
import com.example.yang.tabstest.fragment.ContactsFragment;
import com.example.yang.tabstest.fragment.FindFragment;
import com.example.yang.tabstest.fragment.MeFragment;
import com.example.yang.tabstest.model.ChatItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView bottomChat;

    private TextView bottomContacts;

    private TextView bottomFind;

    private TextView bottomMe;

    private ViewPager viewPager;

    private final String TAG = "MainActivity";

    private TextView currentSelect;

    private ImageView bottomFlag;

    private View[] bottomView = new View[4];

    private LinearLayout.LayoutParams layoutParams;

    private int widthPixels;

    public static List<ChatItem> chatItemList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomChat = (TextView) findViewById(R.id.bottom_chat);
        bottomContacts = (TextView) findViewById(R.id.bottom_contacts);
        bottomFind = (TextView) findViewById(R.id.bottom_find);
        bottomMe = (TextView) findViewById(R.id.bottom_me);
        bottomFlag = (ImageView) findViewById(R.id.bottom_flag);
        viewPager = (ViewPager) findViewById(R.id.view_page);

        initView();


        bottomChat.setOnClickListener(v -> {
            replaceFragment(0);
        });
        bottomContacts.setOnClickListener(v -> {
            replaceFragment(1);
        });
        bottomFind.setOnClickListener(v -> {
            replaceFragment(2);
        });
        bottomMe.setOnClickListener(v -> {
            replaceFragment(3);
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i(TAG, "onPageScrolled: "+position+","+positionOffset+","+positionOffsetPixels);
                layoutParams.leftMargin = position*(widthPixels/4)+positionOffsetPixels/3;
                bottomFlag.setLayoutParams(layoutParams);
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected: "+position);
                replaceFragment(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i(TAG, "onPageScrollStateChanged: "+state);
            }
        });


    }



    private void initView() {

        chatItemList.add(new ChatItem(R.drawable.ic_chat_image1,"梁燕东","来一段文字测试一把看看"));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image2,"潘程佳","来一段文字测试一把看看"));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image3,"东方金融研发中心","来一段文字测试一把看看"));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image4,"亿付数字合作系统","来一段文字测试一把看看"));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image5,"顺丰速运",""));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image6,"一号店",""));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image7,"王漫",""));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image8,"甜橙金融",""));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image9,"张彦峰",""));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image10,"招商银行",""));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image11,"腾讯游戏",""));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image12,"马威",""));
        chatItemList.add(new ChatItem(R.drawable.ic_chat_image13,"蒯越",""));


        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ChatFragment());
        fragmentList.add(new ContactsFragment());
        fragmentList.add(new FindFragment());
        fragmentList.add(new MeFragment());
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentList));
        viewPager.setCurrentItem(0);
        currentSelect = bottomChat;
        bottomView[0] = bottomChat;
        bottomView[1] = bottomContacts;
        bottomView[2] = bottomFind;
        bottomView[3] = bottomMe;

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        widthPixels = displayMetrics.widthPixels;
        Log.i(TAG, "initView: "+widthPixels);
        layoutParams = (LinearLayout.LayoutParams) bottomFlag.getLayoutParams();
        layoutParams.width = widthPixels/4;
        layoutParams.leftMargin=0;
        bottomFlag.setLayoutParams(layoutParams);



    }

    private void replaceFragment(int index) {
        viewPager.setCurrentItem(index);
        currentSelect.setTextColor(Color.BLACK);
        TextView text = (TextView) bottomView[index];
        text.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.bottomSelectTextColor));
        currentSelect = text;
        Log.i(TAG, "initView: "+bottomFlag.getMeasuredWidth());
    }
}
