package com.example.signup.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.signup.G;
import com.example.signup.ModelH.StractCity;

import java.util.ArrayList;

public class CityDatabase extends SQLiteOpenHelper {
    public static String DBNAME;
    public static String TABLE;
    public static String CITY;
    public static String DBLOCATION = "/data/data/" + G.context.getPackageName() + "/databases"+"/" ;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public CityDatabase(Context context, String DBname){
        super(context,DBNAME,null,1);
        DBNAME = DBname + ".db";
        TABLE = "MST_Hospital" ;
        CITY = "District";
        mContext = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public  void OpenDatabase(){

        String DBPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase!= null && mDatabase.isOpen()){
            return;
        }

        mDatabase = SQLiteDatabase.openDatabase(DBPath,null,SQLiteDatabase.OPEN_READWRITE);
    }
    public void CloseDatabase(){
        if(mDatabase!=null){
            mDatabase.close();
        }
        //Get record
    }
    public ArrayList<StractCity> GetCiity() {

        StractCity stractCity = null;
        ArrayList<StractCity> arrayListHospital = new ArrayList<StractCity>();
        // SELECT DISTINCT District FROM MST_Hospital
        OpenDatabase();

//        Cursor cursor = mDatabase.rawQuery( "select * from " + TABLE , null);
        Cursor cursor = mDatabase.query(true, TABLE,null, null, null, CITY, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            stractCity = new StractCity(cursor.getString(9));
            arrayListHospital.add(stractCity);
            cursor.moveToNext();
        }
        cursor.close();
        CloseDatabase();
        ArrayList<StractCity> newList = removeDuplicates(arrayListHospital);

        return newList;
    }


    private ArrayList<StractCity> removeDuplicates(ArrayList<StractCity> arrayListHospital) {
        ArrayList<StractCity> newList = new ArrayList<StractCity>();
        for (StractCity element : arrayListHospital) {

            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        return newList;
    }

}

