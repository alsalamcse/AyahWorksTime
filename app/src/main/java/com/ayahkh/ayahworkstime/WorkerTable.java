package com.ayahkh.ayahworkstime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.WrapperListAdapter;

import java.util.ArrayList;


public class WorkerTable extends SQLiteOpenHelper

{
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="WORKER_DB";
    private static final String TABLE_WORKER="WORKER_TBL";
    private static final String KEY_ID="id";
    private static final String KEY_TIMEIN ="timein";
    private static final  String KEY_TIMEOUT ="timeout";
    private static final String KEY_DATE="date";




    public WorkerTable(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate="CREATE TABLE "+TABLE_WORKER
                +"("
                +KEY_ID+" INTEGER PRIMARY KEY,"
                +KEY_TIMEIN +" TEXT,"
                +KEY_TIMEOUT+" TEXT,"
                +KEY_DATE+" TEXT"+
                ")";
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDrop="DROP TABLE IF EXUST"+TABLE_WORKER;
        db.execSQL(sqlDrop);
        onCreate(db);


    }

    public long addWorker(Worker worker)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_TIMEIN,worker.getTimein());
        values.put(KEY_TIMEOUT,worker.getTimeout());
        values.put(KEY_TIMEOUT,worker.getDate());

        long row=db.insert(TABLE_WORKER,null,values);
        db.close();
        return row;

    }

    public int updateWorker(Worker worker)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_TIMEIN,worker.getTimein());
        values.put(KEY_TIMEOUT,worker.getTimeout());
        values.put(KEY_DATE,worker.getDate());

        int num=db.update(TABLE_WORKER,values,KEY_ID+"="+worker,null);
        db.close();
        return num;

    }
    public int deleteWorkerById(Worker worker) {
        SQLiteDatabase db = this.getWritableDatabase();
        int num = db.delete(TABLE_WORKER, KEY_ID + "=" +worker.getId(), null);
        db.close();
        return num;
    }


    public  ArrayList<Worker> getAllTables()
    {
        ArrayList<Worker>workerList=new ArrayList<Worker>();
        String selectQuery="SELECT * FROM "+TABLE_WORKER;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        boolean isThere=cursor.moveToFirst();

        while (isThere==true)
        {
            Worker worker=new Worker();
            worker.setId(cursor.getLong(0));
            worker.setTimein(cursor.getString(1));
            worker.setTimeout(cursor.getString(2));
            worker.setDate(cursor.getString(3));
            workerList.add(worker);
            isThere=cursor.moveToNext();




            }
return workerList;
        }

    }








