package com.example.aiiti.madprice.AddDevicePage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aiiti.madprice.Adaptor.ShopkeeperAdaptor;
import com.example.aiiti.madprice.R;
import com.example.aiiti.madprice.Shopkeeper.ShopkeeperDatum;
import com.example.aiiti.madprice.Shopkeeper.Shopkeeperregdata;
import com.example.aiiti.madprice.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aiiti on 12/31/2016.
 */

public class UpdatePage extends AppCompatActivity {
    JSONObject obj;
    ListView listView;
    List<ShopkeeperDatum> list;
    Shopkeeperregdata shopkeeperregdata = new Shopkeeperregdata();
    ShopkeeperDatum data[];
    ShopkeeperAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        Intent intent = getIntent();

        listView = (ListView) findViewById(R.id.listv);
        list = new ArrayList<>();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL.SKURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    data = new ShopkeeperDatum[10];
                    //jsonArray.length()
                    for (int i = 0; i < jsonArray.length(); i++) {
                        obj = jsonArray.getJSONObject(i);
                        data[i] = new ShopkeeperDatum();
                        data[i].setSname(obj.getString("sname"));
                        data[i].setSemail(obj.getString("semail"));
                        data[i].setSpassword(obj.getString("spassword"));
                        data[i].setSlocation(obj.getString("slocation"));
                        data[i].setSshopname(obj.getString("sshopname"));
                        list.add(data[i]);
                    }
                    shopkeeperregdata.setData(list);
                    adaptor = new ShopkeeperAdaptor(getApplicationContext(), R.layout.mylayout, list);
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

