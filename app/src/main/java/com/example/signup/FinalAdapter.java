package com.example.signup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signup.ModelH.StractFinal;

import java.util.ArrayList;
import java.util.List;

public class FinalAdapter extends RecyclerView.Adapter<com.example.signup.FinalAdapter.ViewHolder>  {

private final Context context;
private final List<StractFinal> modelPersonList;
private List<StractFinal> doctorsListAll;

public FinalAdapter(List<StractFinal> modelPersonList, Context context) {
        this.modelPersonList = modelPersonList;
        this.context = context;
        doctorsListAll = new ArrayList<>(modelPersonList);
        }

@NonNull
@Override
public com.example.signup.FinalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.findetails, parent, false);
        return new com.example.signup.FinalAdapter.ViewHolder(itemView);
        }

@Override
public void onBindViewHolder(@NonNull com.example.signup.FinalAdapter.ViewHolder holder, int position) {

        StractFinal modelPerson = modelPersonList.get(position);
        holder.HospitalName.setText(modelPerson.getAddress());
        holder.Mobile.setText(modelPerson.getCity());
        }

@Override
public int getItemCount() {
        return modelPersonList.size();
        }

//@Override
//public Filter getFilter() {
//        return filter;
//        }
//
//private Filter filter = new Filter() {
//
//// runs on background thread
//
//@Override
//protected FilterResults performFiltering(CharSequence constraint) {
//
//
//        List<StractFinal> filteredList = new ArrayList<>();
//
//        if (constraint == null || constraint.length() == 0) {
//        filteredList.addAll(doctorsListAll);
//        } else {
//        String filterPattern = constraint.toString().toLowerCase().trim();
//
//        for (StractFinal item : doctorsListAll) {
//        if (item.getHosc().toLowerCase().contains(filterPattern)) {
//        filteredList.add(item);
//        }
//        }
//        }
//        FilterResults results = new FilterResults();
//        results.values = filteredList;
//
//        return results;
//        }
//
//// runs on ui thread
//@Override
//protected void publishResults(CharSequence constraints, FilterResults results) {
//        modelPersonList.clear();
//        modelPersonList.addAll((List) results.values);
//        notifyDataSetChanged();
//        }
//        };

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView HospitalName,Mobile;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        HospitalName = itemView.findViewById(R.id.HOSPITALNAME);
        Mobile = itemView.findViewById(R.id.MOBILENUMBER);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "Aur bhai", Toast.LENGTH_SHORT).show();
        //StractFinal modelPerson = modelPersonList.get(getAdapterPosition());
//        Intent intent = new Intent(context,FinalHospital.class);
//        intent.putExtra("Hospital",modelPerson.getHosc());
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
       // Toast.makeText(context, modelPerson.getHosc(), Toast.LENGTH_SHORT).show();
    }
}
}