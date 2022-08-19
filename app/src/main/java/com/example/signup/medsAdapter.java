package com.example.signup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class medsAdapter extends RecyclerView.Adapter<medsAdapter.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<medsItem> mExampleList;

    public medsAdapter(Context context, ArrayList<medsItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @androidx.annotation.NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.meds_item, parent, false);
        return new ExampleViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull ExampleViewHolder holder, int position) {
        medsItem currentItem = mExampleList.get(position);

        // Log.d("EXAMPLE", currentItem.getState());

        String medicine = currentItem.getMedicine();
        String price = currentItem.getPrice();
        String use = currentItem.getUse();
        String sideEffects = currentItem.getSideEffects();


        holder.mTextViewMedicine.setText("Medicine : " + medicine);

        holder.mTextViewPrice.setText("Price : " + String.valueOf(price));
        holder.mTextViewUse.setText("Use : " + String.valueOf(use));
        holder.mTextViewSide_effects.setText("Side Effects : " + String.valueOf(sideEffects));



    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewMedicine;
        public TextView mTextViewPrice;
        public TextView mTextViewUse;
        public TextView mTextViewSide_effects;


        public ExampleViewHolder(@androidx.annotation.NonNull View itemView) {
            super(itemView);
            mTextViewMedicine = itemView.findViewById(R.id.Medicine_name);
            mTextViewPrice = itemView.findViewById(R.id.price_tag);
            mTextViewUse = itemView.findViewById(R.id.use_case);
            mTextViewSide_effects = itemView.findViewById(R.id.side__effects_of);

        }
    }
}
