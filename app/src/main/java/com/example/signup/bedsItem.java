package com.example.signup;

public class bedsItem {

    private String mState;
    private int mRuralHospital;
    private int mRuralBed;
    private int mUrbanHospital;
    private int mUrbanBed;
    private int mTotalHospital;
    private int mTotalBed;

    public bedsItem(String state, int ruralHospital, int ruralBed, int urbanHospital, int urbanBed, int totalHospital, int totalBed){
        mState = state;
        mRuralHospital = ruralHospital;
        mRuralBed = ruralBed;
        mUrbanHospital = urbanHospital;
        mUrbanBed = urbanBed;
        mTotalHospital = totalHospital;
        mTotalBed = totalBed;
    }

    public String getState(){
        return mState;
    }

    public int getRuralHospital(){
        return mRuralHospital;
    }

    public int getRuralBed(){
        return mRuralBed;
    }

    public int getUrbanHospital(){
        return mUrbanHospital;
    }

    public int getUrbanBed(){
        return mUrbanBed;
    }

    public int getTotalHospital(){
        return mTotalHospital;
    }

    public int getTotalBed(){
        return mTotalBed;
    }
}
