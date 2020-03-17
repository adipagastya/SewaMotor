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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DaftarActivity extends AppCompatActivity {

    private EditText name, username, password, email, telpon;
    private Button regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        regist = (Button) findViewById(R.id.btnDaftar);

        name        = findViewById(R.id.inpNama);
        username    = findViewById(R.id.inpUsername);
        password    = findViewById(R.id.inpPass);
        email       = findViewById(R.id.inpMail);
        telpon      = findViewById(R.id.inpTelp);

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mNama    = name.getText().toString().trim();
                String mUser    = username.getText().toString().trim();
                String mPass    = password.getText().toString().trim();
                String mEmail   = email.getText().toString().trim();
                String mTelp    = telpon.getText().toString().trim();
                if (!mNama.isEmpty()||!mUser.isEmpty() || !mPass.isEmpty()|| !mEmail.isEmpty()){
                    register(mNama,mUser,mPass,mEmail,mTelp);
                }else{
                    name.setError("Masukan Nama");
                    username.setError("Masukan Username");
                    password.setError("Masukan Password");
                    email.setError("Masukan Email");
                    telpon.setError("Masukan No. Telepon");
                }
            }
        });
    }

    private void register(final String nama, final String username, final String password, final String email, final String telpon){
        regist.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, API.API_REGIS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");

                    if (success.equals("1")){
                        Toast.makeText(DaftarActivity.this, "Register Berhasil", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DaftarActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(DaftarActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                    Toast.makeText(DaftarActivity.this, "Username Sudah Terdaftar!", Toast.LENGTH_SHORT).show();
                    regist.setVisibility(View.VISIBLE);
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DaftarActivity.this, "No Internet", Toast.LENGTH_SHORT).show();
                        regist.setVisibility(View.VISIBLE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nama",nama);
                params.put("username",username);
                params.put("password",password);
                params.put("email",email);
                params.put("telpon",telpon);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
