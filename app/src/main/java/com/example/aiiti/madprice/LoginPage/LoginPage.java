package com.example.aiiti.madprice.LoginPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aiiti.madprice.AdminPage.AdminPage;
import com.example.aiiti.madprice.R;
import com.example.aiiti.madprice.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.R.attr.password;

public class LoginPage extends AppCompatActivity {
    EditText v_lemail, v_lpassword;
    Button v_signin;
    String v_e, v_p;
    int v_id;
    JSONObject obj;
    String[] email, password;
    int[] id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        v_lemail = (EditText) findViewById(R.id.lemailtv);
        v_lpassword = (EditText) findViewById(R.id.lpasswordtv);
        v_signin = (Button) findViewById(R.id.signinbtn);

        v_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, URL.SKURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            email = new String[jsonArray.length()];
                            password = new String[jsonArray.length()];
                            id = new int[jsonArray.length()];
                            for (int i = 0; i < jsonArray.length(); i++) {
                                obj = jsonArray.getJSONObject(i);
                                email[i] = obj.getString("semail");
                                password[i] = obj.getString("spassword");
                                id[i] = obj.getInt("id");
                            }
                            v_e = v_lemail.getText().toString();
                            v_p = v_lpassword.getText().toString();
                            for (int j = 0; j < jsonArray.length(); j++) {
                                if (v_e.equals(email[j]) && v_p.equals(password[j])) {
                                    v_id = id[j];
                                    Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(LoginPage.this, AdminPage.class);
                                    intent.putExtra("ID", v_id);
                                    startActivity(intent);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }
        });
    }
}
