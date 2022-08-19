package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class beds_home extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private bedsAdapter mBedsAdapter;
    private ArrayList<bedsItem> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beds_home);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();

    }

    private void parseJSON() {
        String url = "https://api.rootnet.in/covid19-in/hospitals/beds";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject data = response.getJSONObject("data");
                            JSONArray jsonArray = data.getJSONArray("regional");


                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject regionals = jsonArray.getJSONObject(i);

                                String stateName = regionals.getString("state");
                                int ruralHospitals = regionals.getInt("ruralHospitals");
                                int ruralBeds = regionals.getInt("ruralBeds");
                                int urbanHospitals = regionals.getInt("urbanHospitals");
                                int urbanBeds = regionals.getInt("urbanBeds");
                                int totalHospitals = regionals.getInt("totalHospitals");
                                int totalBeds = regionals.getInt("totalBeds");

                                mExampleList.add(new bedsItem(stateName, ruralHospitals, ruralBeds, urbanBeds, urbanHospitals, totalHospitals, totalBeds));
                            }

                            mBedsAdapter = new bedsAdapter(beds_home.this, mExampleList);
                            mRecyclerView.setAdapter(mBedsAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}