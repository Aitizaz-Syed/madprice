package com.example.aiiti.madprice.Fragment;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aiiti.madprice.Adaptor.EdeviceAdaptor;
import com.example.aiiti.madprice.Edevice.EdeviceDatum;
import com.example.aiiti.madprice.Edevice.Edevicedata;
import com.example.aiiti.madprice.R;
import com.example.aiiti.madprice.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FragmentA extends android.app.Fragment {
    TextView v_id;
    JSONObject obj;
    ListView listView;
    List<EdeviceDatum> list;
    Edevicedata edevicedata = new Edevicedata();
    EdeviceDatum data[];
    EdeviceAdaptor adaptor;
    ListItemSelectedListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL.EDURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    data = new EdeviceDatum[jsonArray.length()];
                    for (int i = 0; i < jsonArray.length(); i++) {
                        obj = jsonArray.getJSONObject(i);
                        data[i] = new EdeviceDatum();
                        data[i].setDname(obj.getString("dname"));
                        data[i].setDprice(obj.getString("dprice"));
                        data[i].setDtype(obj.getString("dtype"));
                        data[i].setDcondition(obj.getString("dcondition"));
                        data[i].setDstock(obj.getString("dstock"));
                        data[i].setId(obj.getInt("id"));
                        list.add(data[i]);
                    }
                    edevicedata.setData(list);
                    adaptor = new EdeviceAdaptor(getActivity(), R.layout.mylayout, list);
                    listView.setAdapter(adaptor);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenta, container, false);
        listView = (ListView) view.findViewById(R.id.NameList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EdeviceDatum emp = (EdeviceDatum) adaptor.getItem(position);

//                            EdeviceDatum emp = (EdeviceDatum) listView.getItemAtPosition(position);
                listener.ItemSelected(emp);
//                            data[0] = (EdeviceDatum) listView.getItemAtPosition(position);
                //  Intent intent = new Intent(getActivity(), SecondActivity.class);
//                            intent.putExtra("dname", data[0].getDname());
//                            intent.putExtra("dprice", data[0].getDprice());
//                            intent.putExtra("dtype", data[0].getDtype());
//                            intent.putExtra("dcondition", data[0].getDcondition());
//                            intent.putExtra("dstock", data[0].getDstock());
                // startActivity(intent);

            }
        });

        return view;
    }

    public interface ListItemSelectedListener {
        public void ItemSelected(EdeviceDatum data);
    }

    public void setActivateOnItemClick(boolean activateOnItemClick) {
        listView.setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ListItemSelectedListener) {
            listener = (ListItemSelectedListener) getActivity();
        } else {
            throw new RuntimeException(activity.toString() + "must implement FragmentA.listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
