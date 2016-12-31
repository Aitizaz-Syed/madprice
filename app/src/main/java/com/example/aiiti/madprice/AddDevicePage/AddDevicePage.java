package com.example.aiiti.madprice.AddDevicePage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aiiti.madprice.R;
import com.example.aiiti.madprice.URL;

import java.util.HashMap;
import java.util.Map;

public class AddDevicePage extends AppCompatActivity {
    EditText v_name, v_price, v_type;
    Spinner v_conditon, v_stock;
    Button v_post;
    int v_condid, v_stockid;
    String n, p, t;
    public static final String v_UTAG = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device_page);
        v_name = (EditText) findViewById(R.id.nametxt);
        v_price = (EditText) findViewById(R.id.pricetxt);
        v_type = (EditText) findViewById(R.id.typetxt);
        v_post = (Button) findViewById(R.id.postbtn);
        v_conditon = (Spinner) findViewById(R.id.condtionspin);
        v_stock = (Spinner) findViewById(R.id.stockspin);


        v_conditon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("New")) {
                    v_condid = 1;
                }
                if (selectedItem.equals("Used")) {
                    v_condid = 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        v_stock.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Available")) {
                    v_stockid = 1;
                }
                if (selectedItem.equals("Not Available")) {
                    v_stockid = 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        v_post.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                n = v_name.getText().toString();
                p = v_price.getText().toString();
                t = v_type.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.EDURL, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddDevicePage.this, error.toString(), Toast.LENGTH_LONG).show();

                    }
                }) {
                    protected Map<String, String> getParams() {

                        Map<String, String> params = new HashMap<String, String>();

                        params.put("dname", n);
                        params.put("dprice", p);
                        params.put("dtype", t);
                        params.put("dcondition", String.valueOf(v_condid));
                        params.put("dstock", String.valueOf(v_stockid));
                        params.put("Dusertag", v_UTAG);


                        return params;
                    }


                };


                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);


            }


        });

    }
}
