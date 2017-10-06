package com.example.yang.uibestpracitce.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yang.uibestpracitce.R;
import com.example.yang.uibestpracitce.model.Msg;

import java.util.List;


public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> msgList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;

        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout = itemView.findViewById(R.id.left_layout);
            rightLayout = itemView.findViewById(R.id.right_layout);
            leftMsg = itemView.findViewById(R.id.left_msg);
            rightMsg = itemView.findViewById(R.id.right_msg);
        }
    }

    public MsgAdapter(List<Msg> msgList) {
        this.msgList = msgList;
    }

    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
        Msg msg = msgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        } else if (msg.getType() ==  Msg.TYPE_SEND){
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


}
