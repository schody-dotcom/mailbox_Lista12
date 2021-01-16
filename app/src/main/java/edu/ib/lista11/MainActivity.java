package edu.ib.lista11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    public static final String FOLDERNAME = "Historia_wiadomosci";
    public static final String FILERNAME = "test2.txt";
    public static final String MSG = "Hello Android World!";
    public static final String TAG = "EDUIB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.edtMessage);
        String message = editText.getText().toString();

        Intent intent2 = new Intent(Intent.ACTION_SEND);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(intent2);

        String FILENAME = LocalDate.now().toString()+".txt";

        Context context = getApplicationContext();
        String folder = context.getFilesDir().getAbsolutePath()+ File.separator+FOLDERNAME;
        File subfolder = new File(folder);

        if(!subfolder.exists())
            subfolder.mkdirs();


        try(FileOutputStream os = new FileOutputStream(new File(subfolder,FILENAME), true )) {
            os.write((message+"\n").getBytes());
        } catch (FileNotFoundException e) {
            Log.e(TAG,e.toString());
        } catch (IOException e) {
            Log.e(TAG,e.toString());
        }


    }

    public void onHistory(View view) {


        Intent intent = new Intent(this, HistoryActivity.class);

        startActivity(intent);

    }
}