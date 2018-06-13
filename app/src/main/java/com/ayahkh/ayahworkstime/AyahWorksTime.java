package com.ayahkh.ayahworkstime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class AyahWorksTime extends AppCompatActivity implements View.OnClickListener {

    private int allWorker;
    private Button Save;
    private EditText Timein;
    private EditText Timeout;
    private EditText Date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayah_works_time);
        Save = (Button) findViewById(R.id.Save);
        Timein=(EditText)findViewById(R.id.Timein);
        Timeout=(EditText)findViewById(R.id.Timeout);
        Date=(EditText)findViewById(R.id.Date);



    }


    public int getAllWorker() {
        return allWorker;
    }

    @Override
    public void onClick(View view) {

        if (view == Save) {
            String timein=Timein.getText().toString();
            String timeout=Timeout.getText().toString();
            String date=Date.getText().toString();

            Worker w=new Worker();
            w.setTimein(timein);
            w.setTimeout(timeout);
            w.setDate(date);
            Intent intent = new Intent(this, Timer.class);
            startActivity(intent);
        }
    }
}
