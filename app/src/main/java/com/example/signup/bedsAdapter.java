package com.example.signup;

import android.content.Context;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.NonNull;

public class bedsAdapter extends RecyclerView.Adapter<bedsAdapter.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<bedsItem> mExampleList;

    public bedsAdapter(Context context, ArrayList<bedsItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @NonNull
    @androidx.annotation.NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull @androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.beds_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @androidx.annotation.NonNull ExampleViewHolder holder, int position) {
        bedsItem currentItem = mExampleList.get(position);

        // Log.d("EXAMPLE", currentItem.getState());

        String state = currentItem.getState();
        int ruralHospital = currentItem.getRuralHospital();
        int ruralBed = currentItem.getRuralBed();
        int urbanHospital = currentItem.getUrbanHospital();
        int urbanBed = currentItem.getUrbanBed();
        int totalHospital = currentItem.getTotalHospital();
        int totalBed = currentItem.getTotalBed();

        holder.mTextViewStates.setText("State : " + state);

        holder.mTextViewRuralHospital.setText("Rural Hospital : " + String.valueOf(ruralHospital));
        holder.mTextViewRuralBed.setText("Rural Bed : " + String.valueOf(ruralBed));
        holder.mTextViewUrbanHospital.setText("Urban Hospital : " + String.valueOf(urbanHospital));
        holder.mTextViewUrbanBed.setText("Urban Bed : " + String.valueOf(urbanBed));
        holder.mTextViewTotalBed.setText("Total Bed : " + String.valueOf(totalBed));
        holder.mTextViewTotalHospital.setText("Total Hospital : " + String.valueOf(totalHospital));


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewStates;
        public TextView mTextViewUrbanHospital;
        public TextView mTextViewUrbanBed;
        public TextView mTextViewRuralHospital;
        public TextView mTextViewRuralBed;
        public TextView mTextViewTotalHospital;
        public TextView mTextViewTotalBed;

        public ExampleViewHolder(@NonNull @androidx.annotation.NonNull View itemView) {
            super(itemView);
            mTextViewStates = itemView.findViewById(R.id.State_name);
            mTextViewRuralHospital = itemView.findViewById(R.id.rural_hospital_name);
            mTextViewRuralBed = itemView.findViewById(R.id.rural_bed_name);
            mTextViewUrbanHospital = itemView.findViewById(R.id.urabn_hospital_name);
            mTextViewUrbanBed = itemView.findViewById(R.id.urban_bed_name);
            mTextViewTotalHospital = itemView.findViewById(R.id.total_hospital_name);
            mTextViewTotalBed = itemView.findViewById(R.id.total_bed_name);
        }
    }
}
