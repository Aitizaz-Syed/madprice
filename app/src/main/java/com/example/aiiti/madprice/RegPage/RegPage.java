package com.example.aiiti.madprice.RegPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.example.aiiti.madprice.R;

import java.util.HashMap;
import java.util.Map;

import static android.accounts.AccountManager.KEY_PASSWORD;

public class RegPage extends AppCompatActivity {
    public static final String REG_URL = "http://192.168.10.9/api/shopkeeperregs";
    EditText s_name, s_email, s_password, s_location, s_shopname;
    Button s_ca;
    String v_name, v_email, v_password, v_location, v_shopname;
    public static final String k_name = "sname", k_email = "semail", k_password = "spassword", k_location = "slocation", k_shopname = "sshopname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_page);
        s_name = (EditText) findViewById(R.id.nameedt);
        s_email = (EditText) findViewById(R.id.emailedt);
        s_password = (EditText) findViewById(R.id.passwordedt);
        s_location = (EditText) findViewById(R.id.locationedt);
        s_shopname = (EditText) findViewById(R.id.shopnameedt);
        s_ca = (Button) findViewById(R.id.cabtn);

        s_ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v_name = s_name.getText().toString();
                v_email = s_email.getText().toString();
                v_password = s_password.getText().toString();
                v_location = s_location.getText().toString();
                v_shopname = s_shopname.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, REG_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(RegPage.this, response, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(RegPage.this, error.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put(k_name, v_name);
                        params.put(k_email, v_email);
                        params.put(k_password, v_password);
                        params.put(k_location, v_location);
                        params.put(k_shopname, v_shopname);
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }
        });
    }
}
