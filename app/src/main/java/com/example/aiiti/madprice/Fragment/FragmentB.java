package com.example.aiiti.madprice.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.aiiti.madprice.Edevice.EdeviceDatum;
import com.example.aiiti.madprice.MD.MainActivity;
import com.example.aiiti.madprice.R;
import com.example.aiiti.madprice.URL;

import java.util.HashMap;
import java.util.Map;


public class FragmentB extends Fragment {
    EditText v_dname, v_dprice, v_dtype;
    Button v_update, v_delete;
    Spinner v_conditon, v_stock;
    int v_condid, v_stockid, v_id;
    String n, p, t;
    //    public static final String v_UTAG = "1";
    private EdeviceDatum employee;

    public static FragmentB newInstance(EdeviceDatum employee) {
        FragmentB fragmentDemo = new FragmentB();
        Bundle bd = new Bundle();
        bd.putSerializable("employee", employee);
        fragmentDemo.setArguments(bd);
        return fragmentDemo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employee = (EdeviceDatum) getArguments().getSerializable("employee");
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmentb, container, false);
        v_dname = (EditText) view.findViewById(R.id.nametxt);
        v_dprice = (EditText) view.findViewById(R.id.pricetxt);
        v_dtype = (EditText) view.findViewById(R.id.typetxt);
        v_conditon = (Spinner) view.findViewById(R.id.condtionspin);
        v_stock = (Spinner) view.findViewById(R.id.stockspin);
        v_update = (Button) view.findViewById(R.id.updatebtn);
        v_delete = (Button) view.findViewById(R.id.deletebtn);
        v_id = employee.getId();
        v_dname.setText(employee.getDname());
        v_dprice.setText(employee.getDprice());
        v_dtype.setText(employee.getDtype());

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


        v_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = v_dname.getText().toString();
                p = v_dprice.getText().toString();
                t = v_dtype.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.PUT, URL.EDURL + v_id, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                }) {
                    protected Map<String, String> getParams() {

                        Map<String, String> params = new HashMap<String, String>();

                        params.put("dname", n);
                        params.put("dprice", p);
                        params.put("dtype", t);
                        params.put("dcondition", String.valueOf(v_condid));
                        params.put("dstock", String.valueOf(v_stockid));
                        params.put("Dusertag", String.valueOf(v_id));


                        return params;
                    }


                };


                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(stringRequest);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }
        });

        v_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.DELETE, URL.EDURL + v_id, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(stringRequest);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }


}

