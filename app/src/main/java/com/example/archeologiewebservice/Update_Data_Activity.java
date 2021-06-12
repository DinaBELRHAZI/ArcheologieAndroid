package com.example.archeologiewebservice;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class Update_Data_Activity extends AppCompatActivity {

    EditText txtLambertX,txtLambertY,txtRegion,txtDepartement, txtCommune, txtNomDuSite, txtDateDebut, txtDateFin, txtPeriodes, txtThemes, txtTypesIntervention;
    Button btn_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__data_2);

        //            id des champs dans activity_add__data_2.xml
        txtLambertX = findViewById(R.id.edtLambertX);
        txtLambertY = findViewById(R.id.edtLambertY);
        txtRegion = findViewById(R.id.edtRegion);
        txtDepartement = findViewById(R.id.edtDepartement);
        txtCommune = findViewById(R.id.edtCommune);
        txtNomDuSite = findViewById(R.id.edtNomDuSite);
        txtDateDebut = findViewById(R.id.edtDateDebut);
        txtDateFin = findViewById(R.id.edtDateFin);
        txtPeriodes = findViewById(R.id.edtPeriodes);
        txtThemes = findViewById(R.id.edtThemes);
        txtTypesIntervention = findViewById(R.id.edtTypeIntervention);
        btn_insert = findViewById(R.id.btnInsert);

//        Lors du click pour envoyer les données du formulaire
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    insertData();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void insertData() throws JSONException {

//        Insertion des données de chaque champs pour les transmettres
        final String lambertX = txtLambertX.getText().toString().trim();
        final String lambertY = txtLambertY.getText().toString().trim();
        final String region = txtRegion.getText().toString().trim();
        final String departement = txtDepartement.getText().toString().trim();
        final String commune = txtCommune.getText().toString().trim();
        final String nom_du_site = txtNomDuSite.getText().toString().trim();
        final String date_debut = txtDateDebut.getText().toString().trim();
        final String date_fin = txtDateFin.getText().toString().trim();
        final String periodes = txtPeriodes.getText().toString().trim();
        final String themes = txtThemes.getText().toString().trim();
        final String type_intervention = txtTypesIntervention.getText().toString().trim();

//        Message de chargement
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

//        Test des champs vides
        if(lambertX.isEmpty()){
            Toast.makeText(this, "Enter Lambert X", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(lambertY.isEmpty()){
            Toast.makeText(this, "Enter Lambert Y", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(region.isEmpty()){
            Toast.makeText(this, "Enter Region", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(departement.isEmpty()){
            Toast.makeText(this, "Enter Département", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(commune.isEmpty()){
            Toast.makeText(this, "Enter Commune", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(nom_du_site.isEmpty()){
            Toast.makeText(this, "Enter Nom du site", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(date_debut.isEmpty()){
            Toast.makeText(this, "Enter date debut", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(date_fin.isEmpty()){
            Toast.makeText(this, "Enter date fin", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(periodes.isEmpty()){
            Toast.makeText(this, "Enter périodes", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(themes.isEmpty()){
            Toast.makeText(this, "Enter themes", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(type_intervention.isEmpty()){
            Toast.makeText(this, "Enter types d'intervention", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
//            Affichage du chargement
            progressDialog.show();
//            Insertions des données dans chaque champs qui lui correspond
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("Lambert_X", lambertX);
            jsonBody.put("Lambert_Y", lambertY);
            jsonBody.put("Region", region);
            jsonBody.put("Departement", departement);
            jsonBody.put("Commune", commune);
            jsonBody.put("Nom_du_site", nom_du_site);
            jsonBody.put("Date_debut", date_debut);
            jsonBody.put("Date_fin", date_fin);
            jsonBody.put("Periodes", periodes);
            jsonBody.put("Themes", themes);
            jsonBody.put("Type_intervention", type_intervention);
            final String requestBody = jsonBody.toString();

//            Lien de la méthode update du web service
            StringRequest request = new StringRequest(Request.Method.PUT, "http://10.0.2.2:8086/JerseyArcheo/webresources/sites/update/{param}",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("Data Inserted")){
                                Toast.makeText(Update_Data_Activity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                            else{
                                Toast.makeText(Update_Data_Activity.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Update_Data_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

            };


            RequestQueue requestQueue = Volley.newRequestQueue(Update_Data_Activity.this);
            requestQueue.add(request);



        }




    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
