package edu.ib.lista11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ArrayList<Message> messages;
public static final String FOLDERNAME = "Historia_wiadomosci";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        RecyclerView recyclerViewMessages = (RecyclerView) findViewById(R.id.rvMessages);

        messages = this.createMessageList();

        HistoryAdapter historyAdapter = new HistoryAdapter(messages);

        recyclerViewMessages.setAdapter(historyAdapter);

        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
    }
    public ArrayList<Message> createMessageList(){

        ArrayList<Message> messages = new ArrayList<Message>();
        Context context = getApplicationContext();
        String directory = context.getFilesDir().getAbsolutePath() + File.separator + FOLDERNAME;
        File file = new File(directory);
        String[] directories = file.list((current, name) -> name.endsWith(".txt"));


        for (int i = 0; i < directories.length; i++) {


            try {

                FileInputStream fileInputStream = new FileInputStream(directory+File.separator+directories[i]);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader br = new BufferedReader(inputStreamReader);

                String line;

                while ((line = br.readLine()) != null) {
                    messages.add(new Message(line, directories[i].replace(".txt"," ")));
                }


            } catch (FileNotFoundException e) {
                Log.e("error", e.toString());
            } catch (IOException e) {
                Log.e("error", e.toString());
            }
        }

        return messages;
    }
}