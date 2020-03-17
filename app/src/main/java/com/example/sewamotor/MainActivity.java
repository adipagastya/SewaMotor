package com.example.sewamotor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button login, daftar;
    private EditText username , password;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);
        username = findViewById(R.id.inpUsername);
        password = findViewById(R.id.inpPass);
        login = findViewById(R.id.btnMasuk);
        daftar = findViewById(R.id.btnDaftar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mUser = username.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if (!mUser.isEmpty() || !mPass.isEmpty()){
                    Login(mUser, mPass);
                }else{
                    username.setError("Masukan Username");
                    password.setError("Masukan Password");
                }
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DaftarActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Login(final String username, final String password){
        login.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, com.example.sewamotor.API.API_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (success.equals("1")){

                                for (int i = 0; i < jsonArray.length();i++){
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String nama  = object.getString("nama").trim();
                                    String username = object.getString("username").trim();
                                    String id_user  = object.getString("id_user").trim();

                                    sessionManager.createSession(nama, username, id_user);

                                    Intent intent = new Intent(MainActivity.this, BerandaActivity.class);
                                    startActivity(intent);
                                    finish();
//
//                                    DonasiHewan.id_usr = id_user;
//                                    AdopsiHewan.id_usr = id_user;
//                                    Saya.id_usr = id_user;
//                                    ListMyAdopsi.id_usr = id_user;
//                                    ListMyDonasi.id_usr = id_user;
                                }
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                            login.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Username atau Password Salah! ", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        login.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "No Internet", Toast.LENGTH_SHORT).show();
                    }
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
