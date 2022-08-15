package com.example.signup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterPerson extends RecyclerView.Adapter<AdapterPerson.ViewHolder> {

    private final Context context;
    private final List<ModelPerson> modelPersonList;

    public AdapterPerson(List<ModelPerson> modelPersonList, Context context) {
        this.modelPersonList = modelPersonList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterPerson.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_state, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPerson.ViewHolder holder, int position) {

        ModelPerson modelPerson = modelPersonList.get(position);
        holder.tvName.setText(modelPerson.getPersonName());
      //  holder.tvEmail.setText(modelPerson.getPersonEmail());

    }

    @Override
    public int getItemCount() {
        return modelPersonList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView tvName;
       // private final TextView tvEmail;
       // private final ImageView ivPersonImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
          //  tvEmail = itemView.findViewById(R.id.tvEmail);
         //   ivPersonImage = itemView.findViewById(R.id.ivPersonImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ModelPerson modelPerson = modelPersonList.get(getAdapterPosition());
            Toast.makeText(context, modelPerson.getPersonName(), Toast.LENGTH_SHORT).show();
        }
    }
}