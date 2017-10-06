package com.example.yang.uibestpracitce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.example.yang.uibestpracitce.adapter.MsgAdapter;
import com.example.yang.uibestpracitce.model.Msg;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Msg> msgList = new ArrayList<>();
        initMsg(msgList);
        EditText inputContent = (EditText) findViewById(R.id.input_text);
        Button send = (Button) findViewById(R.id.send);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MsgAdapter msgAdapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(msgAdapter);
        send.setOnClickListener(view -> {
            String content = inputContent.getText().toString();
            if (!"".equals(content)) {
                Msg ms = new Msg(content, Msg.TYPE_SEND);
                msgList.add(ms);
                msgAdapter.notifyItemInserted(msgList.size() - 1);
                recyclerView.scrollToPosition(msgList.size() - 1);
                inputContent.setText("");
            }
        });
    }

    private void initMsg(List<Msg> msgList) {
        msgList.add(new Msg("Hello guy.", Msg.TYPE_RECEIVED));
        msgList.add(new Msg("Hello. Who is that?", Msg.TYPE_SEND));
        msgList.add(new Msg("This is Tom.Nice talking to you.", Msg.TYPE_RECEIVED));
    }
}
