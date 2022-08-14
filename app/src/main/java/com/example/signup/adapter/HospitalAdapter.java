package com.example.signup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.signup.ModelH.StractHospital;
import com.example.signup.R;

import java.util.List;

//public class HospitalAdapter extends ArrayAdapter<StractHospital>
//
//public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder> {
//    public HospitalAdapter(ArrayList<StractHospital> array) {
//        super(G.context, R.layout.recorditem, array);
//    }
//
//    public static class ViewHolder {
//        public TextView txthname;
//
//
//        public ViewHolder(View view) {
//            txthname = view.findViewById(R.id.aspName);
//
//        }
//
//        public void fill(final ArrayAdapter<StractHospital> adapter, final StractHospital item, final int position) {
//            txthname.setText(item.getHospitalName());
//
//
//        }
//    }
//
//    @Override
//    public View getView(int position, View convertview, ViewGroup parent) {
//        ViewHolder holder;
//        StractHospital item = getItem(position);
//        if (convertview == null) {
//            convertview = G.inflater.inflate(R.layout.recorditem, parent, false);
//            holder = new ViewHolder(convertview);
//            convertview.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertview.getTag();
//        }
//        holder.fill(this, item, position);
//        return convertview;
//
//    }
//}
public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder> {

    private final Context context;
    private final List<StractHospital> modelPersonList;

    public HospitalAdapter(List<StractHospital> modelPersonList, Context context) {
        this.modelPersonList = modelPersonList;
        this.context = context;
    }

    @NonNull
    @Override
    public HospitalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recorditem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalAdapter.ViewHolder holder, int position) {

        StractHospital modelPerson = modelPersonList.get(position);
        holder.tvName.setText(modelPerson.getHospitalName());
        //holder.tvEmail.setText(modelPerson.getPersonEmail());
        //Picasso.get().load(modelPerson.getPersonProfile()).into(holder.ivPersonImage);

    }

    @Override
    public int getItemCount() {
        return modelPersonList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView tvName;
        //  private final TextView tvEmail;
        // private final ImageView ivPersonImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.aspName);
            //tvEmail = itemView.findViewById(R.id.tvEmail);
            //ivPersonImage = itemView.findViewById(R.id.ivPersonImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            StractHospital modelPerson = modelPersonList.get(getAdapterPosition());
            Toast.makeText(context, modelPerson.getHospitalName(), Toast.LENGTH_SHORT).show();
        }
    }
}

