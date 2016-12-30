package com.example.aiiti.madprice.Adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aiiti.madprice.R;
import com.example.aiiti.madprice.Shopkeeper.ShopkeeperDatum;

import java.util.List;

/**
 * Created by Aiiti on 12/28/2016.
 */

public class myAdaptor extends ArrayAdapter {

    public myAdaptor(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public myAdaptor(Context context, int resource, List<ShopkeeperDatum> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.mylayout, null);
        }
        ShopkeeperDatum shopkeeperDatum = (ShopkeeperDatum) getItem(position);

        TextView name = (TextView) v.findViewById(R.id.ntv);
        TextView email = (TextView) v.findViewById(R.id.etv);
        TextView password = (TextView) v.findViewById(R.id.ptv);

        if (name != null) {
            name.setText(shopkeeperDatum.getSname().toString());
        }
        if (email != null) {
            email.setText(shopkeeperDatum.getSemail().toString());
        }
        if (password != null) {
            password.setText(shopkeeperDatum.getSpassword().toString());
        }

        return v;

    }

}

