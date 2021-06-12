package com.example.archeologiewebservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    final String URL_GET_DATA = "http://10.0.2.2:8086/JerseyArcheo/webresources/sites";
    RecyclerView recyclerView;
    FranceAdapter adapter;
    List<France> franceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        franceList = new ArrayList<>();

        loadSites();


    }

    //    Récupération des datas
    private void loadSites() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GET_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)   {
                        try {
                            JSONObject object = new JSONObject(response);
                            //nom du tableau transmis par le web service
                            JSONArray jsonArray = object.getJSONArray("content");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);

                                France sites = new France(
                                        obj.getInt("ID"),
                                        obj.optString("Lambert_X"),
                                        obj.optString("Lambert_Y"),
                                        obj.getString("Region"),
                                        obj.getString("Departement"),
                                        obj.getString("Commune"),
                                        obj.getString("Nom_du_site"),
                                        obj.optString("Date_debut"),
                                        obj.optString("Date_fin"),
                                        obj.optString("Periodes"),
                                        obj.optString("Themes"),
                                        obj.optString("Type_intervention")
                                );

                                franceList.add(sites);
                            }

                            adapter = new FranceAdapter(franceList, getApplicationContext());
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    // Bouttons des activités add, update et one site
    public void btn_add_activity(View view) {
        startActivity(new Intent(getApplicationContext(),Add_Data_Activity.class));
    }

    public void btn_update_activity(View view) {
        startActivity(new Intent(getApplicationContext(),Update_Data_Activity.class));
    }
    public void btn_one_site_activity(View view) {
        startActivity(new Intent(getApplicationContext(),One_Data_Activity.class));
    }

}