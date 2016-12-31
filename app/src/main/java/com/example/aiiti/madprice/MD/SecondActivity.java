package com.example.aiiti.madprice.MD;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aiiti.madprice.Edevice.EdeviceDatum;
import com.example.aiiti.madprice.Fragment.FragmentB;
import com.example.aiiti.madprice.R;

public class SecondActivity extends  AppCompatActivity {
    FragmentB fragmentEDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EdeviceDatum employee = (EdeviceDatum) getIntent().getSerializableExtra("employee");

        if (savedInstanceState == null) {

            fragmentEDetail = FragmentB.newInstance(employee);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.secondContainer, fragmentEDetail);

            ft.commit();
        }

    }

}
