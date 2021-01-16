    package edu.ib.lista11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

    public class ReceiveMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE="message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        TextView tvMessage = (TextView) findViewById(R.id.tvMessage);
                tvMessage.setText(message);
    }
}