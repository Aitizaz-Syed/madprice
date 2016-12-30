package com.example.aiiti.madprice.Adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aiiti.madprice.Edevice.Edevicedata;
import com.example.aiiti.madprice.Edevice.EdeviceDatum;
import com.example.aiiti.madprice.R;

import java.util.List;

/**
 * Created by Aiiti on 12/30/2016.
 */

public class EdeviceAdaptor extends ArrayAdapter {

    public EdeviceAdaptor(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public EdeviceAdaptor(Context context, int resource, List<EdeviceDatum> objects) {
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
        EdeviceDatum edeviceDatum = (EdeviceDatum) getItem(position);

        TextView name = (TextView) v.findViewById(R.id.ntv);
        TextView price = (TextView) v.findViewById(R.id.etv);
        TextView type = (TextView) v.findViewById(R.id.ptv);

        if (name != null) {
            name.setText(edeviceDatum.getDname().toString());
        }
        if (price != null) {
            price.setText(edeviceDatum.getDprice().toString());
        }
        if (type != null) {
            type.setText(edeviceDatum.getDtype().toString());
        }

        return v;

    }

}