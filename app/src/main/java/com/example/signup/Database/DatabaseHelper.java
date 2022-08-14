package com.example.signup.Database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.signup.G;
import com.example.signup.ModelH.StractHospital;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DBNAME;
    public static String TABLE;
    public static String DBLOCATION = "/data/data/" + G.context.getPackageName() + "/databases"+"/" ;
    private Context mContext;
    private SQLiteDatabase mDatabase;
    public DatabaseHelper(Context context, String DBname){
        super(context,DBNAME,null,1);
        DBNAME = DBname + ".db";
        TABLE = "MST_Hospital" ;
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
    public ArrayList<StractHospital> GetHospitals()
    {

        StractHospital stractHospital = null;
        ArrayList<StractHospital> arrayListHospital = new ArrayList<StractHospital>();
        OpenDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from " +  TABLE, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            stractHospital = new StractHospital(cursor.getString(4));
            arrayListHospital.add(stractHospital);
            cursor.moveToNext();
        }
        cursor.close();
        CloseDatabase();
        return arrayListHospital;
    }
}
