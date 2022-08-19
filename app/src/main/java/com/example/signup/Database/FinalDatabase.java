package com.example.signup.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.signup.G;
import com.example.signup.ModelH.StractFinal;

import java.util.ArrayList;

public class FinalDatabase extends SQLiteOpenHelper {
    public static String DBNAME;
    public static String TABLE;
    public static String CITY;
    public static String STATE;
    public static String DBLOCATION = "/data/data/" + G.context.getPackageName() + "/databases"+"/" ;
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private String where;
    public FinalDatabase(Context context, String DBname){
        super(context,DBNAME,null,1);
        DBNAME = DBname + ".db";
        TABLE = "MST_Hospital" ;
        CITY = "District";
        STATE = "State";
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
    public ArrayList<StractFinal> GetCity() {

        StractFinal stractFinal = null;
        ArrayList<StractFinal> arrayListHospital = new ArrayList<StractFinal>();
        // SELECT DISTINCT District FROM MST_Hospital
        OpenDatabase();

//        Cursor cursor = mDatabase.rawQuery( "select * from " + TABLE , null);
        Cursor cursor = mDatabase.query(true, TABLE,null, null, null, CITY, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            stractFinal.Address = cursor.getString(9);
            stractFinal.City = cursor.getString(8);
            arrayListHospital.add(stractFinal);
            cursor.moveToNext();
        }
        cursor.close();
        CloseDatabase();
        ArrayList<StractFinal> newList = removeDuplicates(arrayListHospital);

        return newList;
    }

//    public ArrayList<StractFinal> GetCityFromState(String name) {
//        StractFinal StractFinal = null;
//        ArrayList<StractFinal> arrayListHospital = new ArrayList<StractFinal>();
//        // SELECT DISTINCT District FROM MST_Hospital
//        OpenDatabase();
//// SELECT * FROM MST_Hospital WHERE State = 'Gujarat'
////        Cursor cursor = mDatabase.rawQuery( "select * from " + TABLE , null);
//        //Cursor cursor = mDatabase.rawQuery( "SELECT * FROM MST_Hospital WHERE State = " + "Goa" , null);
//        //  Cursor cursor = mDatabase.query(true, TABLE,null, null, null, CITY, null, null, null);
//        Cursor cursor = mDatabase.rawQuery("select distinct * from " + TABLE + " where State =? group by " + CITY , new String[]{name});
//        // Cursor cursor = mDatabase.query(true, TABLE,columns, STATE, new String[]{name}, CITY, null, null, null);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            com.example.signup.ModelH.StractFinal = new StractFinal(cursor.getString(9));
//            arrayListHospital.add(com.example.signup.ModelH.StractFinal);
//            cursor.moveToNext();
//        }
//        cursor.close();
//        CloseDatabase();
//        ArrayList<StractFinal> newList = removeDuplicates(arrayListHospital);
//
//        return newList;
//    }


//    public ArrayList<StractFinal> Getstatee() {
//
//        StractFinal StractFinal = null;
//        ArrayList<StractFinal> arrayListHospital = new ArrayList<StractFinal>();
//        // SELECT DISTINCT District FROM MST_Hospital
//        OpenDatabase();
//
////        Cursor cursor = mDatabase.rawQuery( "select * from " + TABLE , null);
//        Cursor cursor = mDatabase.query(true, TABLE,null, null, null, STATE, null, null, null);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            com.example.signup.ModelH.StractFinal = new StractFinal(cursor.getString(8));
//            arrayListHospital.add(com.example.signup.ModelH.StractFinal);
//            cursor.moveToNext();
//        }
//        cursor.close();
//        CloseDatabase();
//        ArrayList<StractFinal> newList = removeDuplicatess(arrayListHospital);
//
//        return newList;
//    }


    private ArrayList<StractFinal> removeDuplicates(ArrayList<StractFinal> arrayListHospital) {
        ArrayList<StractFinal> newList = new ArrayList<StractFinal>();
        for (StractFinal element : arrayListHospital) {

            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        return newList;
    }


//    private ArrayList<StractFinal> removeDuplicatess(ArrayList<StractFinal> arrayListHospital) {
//        ArrayList<StractFinal> newList = new ArrayList<StractFinal>();
//        for (StractFinal element : arrayListHospital) {
//
//            if (!newList.contains(element)) {
//
//                newList.add(element);
//            }
//        }
//
//        return newList;
//    }

}

