package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpRequest;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.OkHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class meds_home extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private medsAdapter mMedsAdapter;
    private ArrayList<medsItem> mExampleList;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meds_home);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "https://script.googleusercontent.com/macros/echo?user_content_key=gO2G_XLeYGSMOUEBNrevxcmcBimDWQFgwyZKG38nYYujjEyTezWwZgSZm2Yj9lZJO8H8Xcnnv6RjsPgMrKukJgglXZMjYXuFm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnKRRK943OYXF5ONCw7gQKngh5TZUkDJB-48oiOU4Z1TnoUzJRjbZcQwPzYi-u8Z-YwQDs_0I0awShhbB0aU_288lRakcipT0X9z9Jw9Md8uu&lib=MeOKgIKOcNbpZfJm1QVnK9ZnPCuiv2UYy";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
//                            JSONObject data = response.getJSONObject("data");
                            JSONArray jsonArray = response.getJSONArray("data");


                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject regionals = jsonArray.getJSONObject(i);

                                String medicine = regionals.getString("medicine");
                                String price = regionals.getString("price");
                                String use = regionals.getString("use");
                                String side_Effects = regionals.getString("side_effect");


                                mExampleList.add(new medsItem(medicine, price, use, side_Effects));
                            }

                            mMedsAdapter = new medsAdapter(meds_home.this, mExampleList);
                            mRecyclerView.setAdapter(mMedsAdapter);


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