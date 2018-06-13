package com.ayahkh.ayahworkstime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Timer extends AppCompatActivity
{
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        initListview();
    }



    private void initListview()
    {
        listView=(ListView)findViewById(R.id.lstView);
        WorkerTable worksTime=new WorkerTable(this);
        ArrayAdapter<Worker>adapter=new ArrayAdapter<Worker>(this,android.R.layout.simple_expandable_list_item_1,worksTime.getAllTables());
        listView.setAdapter(adapter);


    }
}
