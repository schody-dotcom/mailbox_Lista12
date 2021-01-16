package edu.ib.lista11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    public HistoryAdapter() {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView messageTextView;
        public TextView dateTextView;


        public ViewHolder(View itemView) {

            super(itemView);

            messageTextView = (TextView) itemView.findViewById(R.id.messageTV);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTV);
        }
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_message, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( HistoryAdapter.ViewHolder holder, int position) {
Message message = messages.get(position);

TextView messageTextView = holder.messageTextView;
messageTextView.setText(message.getTextMessage());
TextView dateTextView = holder.dateTextView;
dateTextView.setText(message.getDateNow().toString());

    }


    @Override
    public int getItemCount() {
        return messages.size();
    }
    private  List<Message> messages;

    public HistoryAdapter(List<Message> messages){
        this.messages=messages;
    }


}