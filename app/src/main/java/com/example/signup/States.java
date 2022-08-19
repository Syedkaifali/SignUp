package com.example.signup;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signup.Database.CityDatabase;
import com.example.signup.ModelH.StractState;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class States extends AppCompatActivity {
    RecyclerView recyclerView;
    List<StractState> myList;
    StateAdapter stateAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states);
        Toolbar toolbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        displayItem();


    }

    private void displayItem() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CityDatabase mDBHELPER = new CityDatabase(States.this, "Hospital");
        File database = getApplicationContext().getDatabasePath(CityDatabase.DBNAME);
        if (!database.exists()) {
            mDBHELPER.getReadableDatabase();
            if (!database.exists()) {
                mDBHELPER.getReadableDatabase();
                if (!copydatabase(States.this)) {
                    return;
                }
            }
        }
        myList = mDBHELPER.Getstatee();
        stateAdapter=new StateAdapter(myList,this);
        stateAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(stateAdapter);

    }

//    private void setAdapter(RecyclerView listHospital) {
//
//    }

    public Boolean copydatabase(Context context) {

        try {
            InputStream inputStream = context.getAssets().open(CityDatabase.DBNAME);
            String OutFileName = CityDatabase.DBLOCATION + CityDatabase.DBNAME;
            File f = new File(OutFileName);
            f.getParentFile().mkdirs();
            OutputStream outputStream = new FileOutputStream(OutFileName);

            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                stateAdapter.getFilter().filter(newText);

                return false;
            }
        });
        return true;
    }
}

//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        setAdapter(recyclerView);
//    }
//
//    private void setAdapter(RecyclerView recyclerView) {
//        List<ModelPerson> modelPersonList = new ArrayList<>();
//        AdapterPerson adapterPerson = new AdapterPerson(modelPersonList, this);
//
//        recyclerView.setAdapter(adapterPerson);
//        ModelPerson person = new ModelPerson("Andaman and Nicobar Islands");
//        modelPersonList.add(person);
//        person = new ModelPerson("Andhra Pradesh");
//        modelPersonList.add(person);
//        person = new ModelPerson("Arunachal Pradesh");
//        modelPersonList.add(person);
//        person = new ModelPerson("Assam");
//        modelPersonList.add(person);
//        person = new ModelPerson("Bihar");
//        modelPersonList.add(person);
//        person = new ModelPerson("Chandigarh");
//        modelPersonList.add(person);
//        person = new ModelPerson("Chhattisgarh");
//        modelPersonList.add(person);
//        person = new ModelPerson("Dadra and Nagar Haveli");
//        modelPersonList.add(person);
//        person = new ModelPerson("Daman and Diu");
//        modelPersonList.add(person);
//        person = new ModelPerson("Goa");
//        modelPersonList.add(person);
//        person = new ModelPerson("Gujarat");
//        modelPersonList.add(person);
//        person = new ModelPerson("Haryana");
//        modelPersonList.add(person);
//        person = new ModelPerson("Himachal Pradesh");
//        modelPersonList.add(person);
//        person = new ModelPerson("Jammu and Kashmir");
//        modelPersonList.add(person);
//        person = new ModelPerson("Jharkhand");
//        modelPersonList.add(person);
//        person = new ModelPerson("Karnataka");
//        modelPersonList.add(person);
//        person = new ModelPerson("Kerala");
//        modelPersonList.add(person);
//        person = new ModelPerson("Lakshadweep");
//        modelPersonList.add(person);
//        person = new ModelPerson("Madhya Pradesh");
//        modelPersonList.add(person);
//        person = new ModelPerson("Maharashtra");
//        modelPersonList.add(person);
//        person = new ModelPerson("Manipur");
//        modelPersonList.add(person);
//        person = new ModelPerson("Meghalaya");
//        modelPersonList.add(person);
//        person = new ModelPerson("Mizoram");
//        modelPersonList.add(person);
//        person = new ModelPerson("Nagaland");
//        modelPersonList.add(person);
//        person = new ModelPerson("Odisha");
//        modelPersonList.add(person);
//        person = new ModelPerson("Puducherry");
//        modelPersonList.add(person);
//        person = new ModelPerson("Punjab");
//        modelPersonList.add(person);
//        person = new ModelPerson("Rajasthan");
//        modelPersonList.add(person);
//        person = new ModelPerson("Sikkim");
//        modelPersonList.add(person);
//        person = new ModelPerson("Tamil Nadu");
//        modelPersonList.add(person);
//        person = new ModelPerson("Telangana");
//        modelPersonList.add(person);
//        person = new ModelPerson("Tripura");
//        modelPersonList.add(person);
//        person = new ModelPerson("Uttar Pradesh");
//        modelPersonList.add(person);
//        person = new ModelPerson("Uttarakhand");
//        modelPersonList.add(person);
//        person = new ModelPerson("West Bengal");
//        modelPersonList.add(person);
//
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search_menu, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                .getFilter().filter(newText);
//
//                return false;
//            }
//        });
//        return true;
//    }
//}