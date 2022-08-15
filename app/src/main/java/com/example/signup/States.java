package com.example.signup;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class States extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        setAdapter(recyclerView);
    }

    private void setAdapter(RecyclerView recyclerView) {
        List<ModelPerson> modelPersonList = new ArrayList<>();
        AdapterPerson adapterPerson = new AdapterPerson(modelPersonList, this);

        recyclerView.setAdapter(adapterPerson);
        ModelPerson person = new ModelPerson("Andaman and Nicobar Islands");
        modelPersonList.add(person);
        person = new ModelPerson("Andhra Pradesh");
        modelPersonList.add(person);
        person = new ModelPerson("Arunachal Pradesh");
        modelPersonList.add(person);
        person = new ModelPerson("Assam");
        modelPersonList.add(person);
        person = new ModelPerson("Bihar");
        modelPersonList.add(person);
        person = new ModelPerson("Chandigarh");
        modelPersonList.add(person);
        person = new ModelPerson("Chhattisgarh");
        modelPersonList.add(person);
        person = new ModelPerson("Dadra and Nagar Haveli");
        modelPersonList.add(person);
        person = new ModelPerson("Daman and Diu");
        modelPersonList.add(person);
        person = new ModelPerson("Goa");
        modelPersonList.add(person);
        person = new ModelPerson("Gujarat");
        modelPersonList.add(person);
        person = new ModelPerson("Haryana");
        modelPersonList.add(person);
        person = new ModelPerson("Himachal Pradesh");
        modelPersonList.add(person);
        person = new ModelPerson("Jammu and Kashmir");
        modelPersonList.add(person);
        person = new ModelPerson("Jharkhand");
        modelPersonList.add(person);
        person = new ModelPerson("Karnataka");
        modelPersonList.add(person);
        person = new ModelPerson("Kerala");
        modelPersonList.add(person);
        person = new ModelPerson("Lakshadweep");
        modelPersonList.add(person);
        person = new ModelPerson("Madhya Pradesh");
        modelPersonList.add(person);
        person = new ModelPerson("Maharashtra");
        modelPersonList.add(person);
        person = new ModelPerson("Manipur");
        modelPersonList.add(person);
        person = new ModelPerson("Meghalaya");
        modelPersonList.add(person);
        person = new ModelPerson("Mizoram");
        modelPersonList.add(person);
        person = new ModelPerson("Nagaland");
        modelPersonList.add(person);
        person = new ModelPerson("Odisha");
        modelPersonList.add(person);
        person = new ModelPerson("Puducherry");
        modelPersonList.add(person);
        person = new ModelPerson("Punjab");
        modelPersonList.add(person);
        person = new ModelPerson("Rajasthan");
        modelPersonList.add(person);
        person = new ModelPerson("Sikkim");
        modelPersonList.add(person);
        person = new ModelPerson("Tamil Nadu");
        modelPersonList.add(person);
        person = new ModelPerson("Telangana");
        modelPersonList.add(person);
        person = new ModelPerson("Tripura");
        modelPersonList.add(person);
        person = new ModelPerson("Uttar Pradesh");
        modelPersonList.add(person);
        person = new ModelPerson("Uttarakhand");
        modelPersonList.add(person);
        person = new ModelPerson("West Bengal");
        modelPersonList.add(person);

    }
}