package com.example.aiiti.madprice.AdminPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.aiiti.madprice.R;
import com.example.aiiti.madprice.Shopkeeper.ShopkeeperDatum;
import com.example.aiiti.madprice.Shopkeeper.Shopkeeperregdata;
import com.example.aiiti.madprice.Adaptor.myAdaptor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AdminPage extends AppCompatActivity {
    TextView v_id;
    JSONObject obj;
    ListView listView;
    List<ShopkeeperDatum> list;
    Shopkeeperregdata shopkeeperregdata = new Shopkeeperregdata();
    ShopkeeperDatum data[];
    myAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        Intent intent = getIntent();
        int id;
        id = intent.getIntExtra("ID", 0);
        v_id = (TextView) findViewById(R.id.idtv);
        v_id.setText("Welcome "+String.valueOf(id));
        listView = (ListView) findViewById(R.id.alistv);
        list = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.10.9/api/shopkeeperregs", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    data = new ShopkeeperDatum[10];
                    //jsonArray.length()
                    for (int i = 0; i < jsonArray.length(); i++) {
                        obj = jsonArray.getJSONObject(i);
                        data[i]=new ShopkeeperDatum();
                        data[i].setSname(obj.getString("sname"));
                        data[i].setSemail(obj.getString("semail"));
                        data[i].setSpassword(obj.getString("spassword"));
                        data[i].setSlocation(obj.getString("slocation"));
                        data[i].setSshopname(obj.getString("sshopname"));
                        list.add(data[i]);
                    }
                    shopkeeperregdata.setData(list);
                    adaptor = new myAdaptor(getApplicationContext(), R.layout.mylayout,list);
                    listView.setAdapter(adaptor);
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
        //shopkeeperregdata.setData(list);
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
